package org.code4everything.demo.springboot.rabbitmq.producer;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import org.code4everything.demo.springboot.rabbitmq.dao.MsgLogDAO;
import org.code4everything.demo.springboot.rabbitmq.domain.MsgLog;
import org.code4everything.demo.springboot.rabbitmq.domain.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author pantao
 * @since 2019/10/8
 */
@Component
public class RabbitProducer {

    private final RabbitTemplate rabbitTemplate;

    private final MsgLogDAO msgLogDAO;

    public RabbitProducer(RabbitTemplate rabbitTemplate, MsgLogDAO msgLogDAO) {
        this.msgLogDAO = msgLogDAO;
        this.rabbitTemplate = rabbitTemplate;
        // 设置确认回调，保证消息100%投递成功的一种方案（注意：需要到配置文件中开启确认机制）
        this.rabbitTemplate.setConfirmCallback((correlationData, ack, s) -> {
            if (ack) {
                // 更新状态为投递成功
                Console.log("publish msg success: {}", correlationData.getId());
                msgLogDAO.updateStatusById(correlationData.getId(), '2');
            } else {
                // 更新状态为投递失败，需要人工处理
                Console.log("publish msg failed: {}", correlationData.getId());
                msgLogDAO.updateStatusById(correlationData.getId(), '1');
            }
        });
    }

    /**
     * 定时任务：处理未确认的消息
     */
    @Scheduled(fixedDelay = 10000)
    public void scheduledPublisher() {
        // 列出未响应的消息
        List<MsgLog> msgLogs = msgLogDAO.listByStatus('0');
        msgLogs.forEach(msgLog -> publishOrder(msgLog, false));
    }

    public void publishOrder(Order order) {
        // 包装消息日志
        MsgLog msgLog = new MsgLog().setId(IdUtil.simpleUUID()).setBody(order.toJsonString()).setStatus('0');
        publishOrder(msgLog.setRetryCount(0).setCreateTime(LocalDateTime.now()), true);
    }

    private void publishOrder(MsgLog msgLog, boolean saveLog) {
        final int maxRetry = 3;
        if (msgLog.getRetryCount() >= maxRetry) {
            // 更新状态为投递失败
            Console.log("消息被投递{}次，仍然失败！", maxRetry);
            msgLogDAO.updateStatusById(msgLog.getId(), '1');
            return;
        }
        if (saveLog) {
            msgLogDAO.saveMsgLog(msgLog);
        } else {
            msgLogDAO.plusRetryById(msgLog.getId());
        }
        // 消息唯一ID
        CorrelationData correlationData = new CorrelationData(msgLog.getId());
        // 需要到rabbitmq中添加exchange以及queue，然后通过routingKey将queue绑定至exchange（支持星号和井号模糊匹配）
        rabbitTemplate.convertAndSend("order-exchange", "order.routing.key", msgLog.getBody(), correlationData);
    }
}
