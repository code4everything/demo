package org.code4everything.demo.springboot.rabbitmq.producer;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import junit.framework.TestCase;
import org.code4everything.demo.springboot.rabbitmq.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitProducerTest extends TestCase {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testPublishOrder() {
        Order order = new Order(RandomUtil.randomString("123456789", 9), "order", LocalDateTime.now());
        // 消息唯一ID
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(IdUtil.simpleUUID());
        // 需要到rabbitmq中添加exchange以及queue，然后通过routingKey将queue绑定至exchange（支持星号和井号模糊匹配）
        rabbitTemplate.convertAndSend("order-exchange", "order.routing.key", order, correlationData);
    }
}
