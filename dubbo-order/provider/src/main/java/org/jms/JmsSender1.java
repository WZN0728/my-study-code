package org.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author wuting
 * @date 2019/03/10
 */
public class JmsSender1 {

    private static Connection connection = null;

    public static Session getSession() {
        Session session = null;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.10.128:61616");
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            //Boolean.FALSE非事务性会话,只有当Boolean.FALSE为FALSE的时候,后面的Session.AUTO_ACKNOWLEDGE这些参数才会生效
            session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
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
            TextMessage textMessage = null;
            for (int i = 0; i < 7; i++) {
                textMessage = session.createTextMessage("Hello,World!!!" + i);
                messageProducer.send(textMessage);
            }
            //更改为非事务性会话之后这行代码就没有意义了
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
