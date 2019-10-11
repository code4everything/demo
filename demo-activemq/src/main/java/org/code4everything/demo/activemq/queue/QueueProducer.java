package org.code4everything.demo.activemq.queue;

import lombok.Cleanup;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author pantao
 * @since 2019/10/11
 */
public class QueueProducer {

    private static final String URL = "tcp://localserver:61616";

    private static final String QUEUE_NAME = "queue-test";

    public static void main(String[] args) throws JMSException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        // 新建连接
        @Cleanup Connection connection = connectionFactory.createConnection();
        // 启动连接
        connection.start();
        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建一个目标队列
        Destination destination = session.createQueue(QUEUE_NAME);
        // 创建一个消息生产者
        MessageProducer messageProducer = session.createProducer(destination);

        for (int i = 0; i < 100; i++) {
            // 创建消息
            TextMessage textMessage = session.createTextMessage("test" + i);
            // 发布消息
            messageProducer.send(textMessage);
            System.out.println("发送消息：" + textMessage.getText());
        }
    }
}
