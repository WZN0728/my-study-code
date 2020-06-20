package org.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author wuting
 * @date 2019/03/11
 */
public class JmsDefineReceiver {

    private static Connection connection = null;

    public static Session getSession() {
        Session session = null;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
            connection = connectionFactory.createConnection();
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
            Destination destination = session.createQueue("first-queue");
            MessageConsumer messageConsumer = session.createConsumer(destination);
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
