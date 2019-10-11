package org.code4everything.demo.activemq.jms.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author pantao
 * @since 2019/10/11
 */
public class JmsProducer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/producer.xml");
        ProducerService producerService = context.getBean(ProducerService.class);
        for (int i = 0; i < 100; i++) {
            producerService.sendMessage("test" + i);
        }
        context.close();
    }
}
