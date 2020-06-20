package com.demo.springbootrabbitmqproducer;

import com.demo.springbootrabbitmqproducer.producer.Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootRabbitmqProducerApplicationTests {

    @Resource
    private Producer producer;

    @Test
    public void sendTest() {
        producer.send();
    }

}
