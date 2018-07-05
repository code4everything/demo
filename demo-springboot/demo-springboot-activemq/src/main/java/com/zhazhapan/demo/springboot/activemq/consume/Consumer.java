package com.zhazhapan.demo.springboot.activemq.consume;

import com.zhazhapan.util.LoggerUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author pantao
 * @since 2018/7/5
 */
@Component
public class Consumer {

    @JmsListener(destination = "demo.counting")
    public void receiveMessage(TextMessage message) throws JMSException {
        LoggerUtils.info("收到报文：{}", message.getText());
    }
}
