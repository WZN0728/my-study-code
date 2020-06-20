package org.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author wuting
 * @date 2019/03/11
 */
public class JmsTopicReceiverPersistend {

    private static Connection connection = null;

    public static Session getSession() {
        Session session = null;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.10.128:61616");
        try {
            connection = connectionFactory.createConnection();
            //持久订阅,要先在provider发送消息之前启动一下,意义就是先注册一下,这种订阅可以消费所有的消息
            //反之就是非持久化消息,这种消息只能订阅客户端启动后服务端发送的消息
            connection.setClientID("DUBBO-ORDER");
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return session;
    }

    public static void main(String[] args) {
        try {
            Session session = getSession();
            //Destination destination = session.createTopic("first-topic");
            Topic topic = session.createTopic("first-topic");
            MessageConsumer messageConsumer = session.createDurableSubscriber(topic, "DUBBO-ORDER");
            TextMessage textMessage = (TextMessage) messageConsumer.receive();
            System.out.println("接收到的消息:" + textMessage.getText());
            //客户端中的session.commit()相当于事务的签收,如果在事务性会话中不签收的话消息就会一直存在
            session.commit();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
