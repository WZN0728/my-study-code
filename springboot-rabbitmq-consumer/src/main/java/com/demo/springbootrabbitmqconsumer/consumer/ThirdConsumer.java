package com.demo.springbootrabbitmqconsumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wuting
 * @date 2020/02/01
 */
@Component
@RabbitListener(queues = "THIRD_QUEUE")
public class ThirdConsumer {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("third queue msg is " + msg);
    }

}
