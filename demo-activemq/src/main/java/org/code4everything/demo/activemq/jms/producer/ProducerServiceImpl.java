package org.code4everything.demo.activemq.jms.producer;

import org.springframework.jms.core.JmsTemplate;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author pantao
 * @since 2019/10/11
 */
public class ProducerServiceImpl implements ProducerService {

    @Resource
    private JmsTemplate jmsTemplate;

    @Resource(name = "queueDestination")
    private Destination destination;

    @Override
    public void sendMessage(String msg) {
        // JMS Template发送消息
        jmsTemplate.send(destination, session -> {
            // 创建一个消息
            return session.createTextMessage(msg);
        });
        System.out.println("发送消息：" + msg);
    }
}
