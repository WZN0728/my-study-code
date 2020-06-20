package org.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author wuting
 * @date 2019/03/10
 */
public class JmsDefineSender {

    private static Connection connection = null;

    public static Session getSession() {
        Session session = null;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            //Boolean.TRUE事务性会话
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return session;
    }

    public static void main(String[] args) {
        try {
            Session session = getSession();
            //创建队列（如果队列已经存在则不会创建， first-queue是队列名称）
            //destination表示目的地
            Destination destination = session.createQueue("first-queue");
            //创建消息接收者
            MessageProducer messageProducer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage("Hello,World!!!");
            messageProducer.send(textMessage);
            //事务性会话中的消息在session.commit()之后消息才能发送出去,相当于数据库中的事务提交操作
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
