package com.demo.springbootrabbitmqconsumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wuting
 * @date 2020/02/01
 */
@Component
@RabbitListener(queues = "FOURTH_QUEUE")
public class FourthConsumer {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("fourth queue msg is " + msg);
    }

}
