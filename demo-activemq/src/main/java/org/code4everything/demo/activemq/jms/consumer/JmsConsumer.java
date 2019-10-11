package org.code4everything.demo.activemq.jms.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author pantao
 * @since 2019/10/11
 */
public class JmsConsumer {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("/consumer.xml");
    }
}
