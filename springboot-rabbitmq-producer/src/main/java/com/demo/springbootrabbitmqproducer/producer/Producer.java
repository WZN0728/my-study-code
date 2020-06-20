package com.demo.springbootrabbitmqproducer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wuting
 * @date 2020/02/01
 */
@Component
public class Producer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    //发送四条消息,通过不同的交换机已经队列
    public void send() {
        rabbitTemplate.convertAndSend("DIRECT_EXCHANGE", "rabbitmq.test", "a msg direct");
        rabbitTemplate.convertAndSend("TOPIC_EXCHANGE", "test1.rabbitmq.demo1", "a msg topic test1");
        rabbitTemplate.convertAndSend("TOPIC_EXCHANGE", "test2.rabbitmq.demo2", "a msg topic test2");
        rabbitTemplate.convertAndSend("FANOUT_EXCHANAGE", "", "a msg fanout");
    }

}
