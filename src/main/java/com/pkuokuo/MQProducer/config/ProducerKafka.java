package com.pkuokuo.MQProducer.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PathVariable;


@AllArgsConstructor
@Slf4j
@Component
public class ProducerKafka {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    //自定义topic
    public static final String TOPIC_TEST = "pkuokuo";

    public String sendMessage(@PathVariable String messge) {
        log.warn("kafkaSend---test---------> " + messge);
        kafkaTemplate.send("test", messge);
        return messge;
    }


    public String sendMessage2(@PathVariable String messge) {
        log.warn("kafkaSend---test---------> " + messge);
//        生产者生产消息
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TOPIC_TEST, messge);
//        生产者监控消息是否生产成功
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                //发送失败的处理
                log.info(TOPIC_TEST + " - 生产者 发送消息失败：" + throwable.getMessage());
            }
            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //成功的处理
                log.info(TOPIC_TEST + " - 生产者 发送消息成功：" + stringObjectSendResult.toString());
            }
        });


        return messge;
    }



}
