package com.zhazhapan.demo.springboot.activemq.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author pantao
 * @since 2018/7/5
 */
@Component
@EnableScheduling
public class Producer {

    private final JmsTemplate jmsTemplate;

    private final Queue counting;

    @Autowired
    public Producer(JmsTemplate jmsTemplate, Queue counting) {
        this.jmsTemplate = jmsTemplate;
        this.counting = counting;
    }

    @Scheduled(fixedDelay = 3000)
    public void sendMessage() {
        jmsTemplate.send(counting, session -> session.createTextMessage("hello activemq"));
    }
}
