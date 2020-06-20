package org.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author wuting
 * @date 2019/03/11
 */
public class JmsReceiver1 {

    private static Connection connection = null;

    public static Session getSession() {
        Session session = null;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.10.128:61616");
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return session;
    }

    public static void main(String[] args) {
        try {
            Session session = getSession();
            Destination destination = session.createQueue("first-queue");
            MessageConsumer messageConsumer = session.createConsumer(destination);
            for (int i = 0; i < 10; i++) {
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                System.out.println("接收到的消息:" + textMessage.getText());
                if (i == 5) {
                    //客户端会确认前六条消息被消费
                    textMessage.acknowledge();
                }
                textMessage.acknowledge();
            }
//            session.commit();
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
