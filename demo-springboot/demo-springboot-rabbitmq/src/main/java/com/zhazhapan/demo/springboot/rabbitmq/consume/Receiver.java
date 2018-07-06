package com.zhazhapan.demo.springboot.rabbitmq.consume;

import com.zhazhapan.util.LoggerUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author pantao
 * @since 2018/7/6
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void process(String hello) {
        LoggerUtils.info("receive: {}", hello);
    }
}
