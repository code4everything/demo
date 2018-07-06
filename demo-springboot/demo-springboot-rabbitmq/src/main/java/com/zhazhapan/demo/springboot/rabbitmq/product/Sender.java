package com.zhazhapan.demo.springboot.rabbitmq.product;

import com.zhazhapan.util.LoggerUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author pantao
 * @since 2018/7/6
 */
@Component
public class Sender {

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public Sender(AmqpTemplate amqpTemplate) {this.amqpTemplate = amqpTemplate;}

    public void send() {
        String context = "hello " + new Date();
        LoggerUtils.info("send: %s", context);
        amqpTemplate.convertAndSend("hello", context);
    }
}
