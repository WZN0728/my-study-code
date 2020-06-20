package org.jms;

import org.apache.activemq.broker.BrokerService;

/**
 * @author wuting
 * @date 2019/03/11
 */
public class DefineBroker {

    //相当于一个实例,一个服务器
    public static void main(String[] args) {
        BrokerService brokerService = new BrokerService();
        try {
            brokerService.setUseJmx(Boolean.TRUE);
            brokerService.addConnector("tcp://localhost:61616");
            brokerService.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
