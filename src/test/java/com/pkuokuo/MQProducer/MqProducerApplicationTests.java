package com.pkuokuo.MQProducer;

import com.alibaba.fastjson.JSON;
import com.pkuokuo.MQProducer.config.ProducerKafka;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MqProducerApplicationTests {
    @Autowired
    ProducerKafka producerKafka;
    @Test
    void contextLoads() {
//        String message = "你好吗？hello";
//        producerKafka.sendMessage2(JSON.toJSONString(message));
//        System.out.println(message);

    }

}
