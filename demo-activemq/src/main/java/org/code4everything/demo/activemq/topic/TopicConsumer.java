package org.code4everything.demo.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author pantao
 * @since 2019/10/11
 */
public class TopicConsumer {

    private static final String URL = "tcp://localserver:61616";

    private static final String TOPIC_NAME = "topic-test";

    public static void main(String[] args) throws JMSException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        // 新建连接
        Connection connection = connectionFactory.createConnection();
        // 启动连接
        connection.start();
        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建一个目标主题
        Destination destination = session.createTopic(TOPIC_NAME);
        // 创建一个消息消费者
        MessageConsumer messageConsumer = session.createConsumer(destination);
        // 创建一个监听器
        messageConsumer.setMessageListener(message -> {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("接收消息：" + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });
    }
}
