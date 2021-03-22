package com.pkuokuo.MQProducer.controller;

import com.alibaba.fastjson.JSON;
import com.pkuokuo.MQProducer.config.ProducerKafka;
import com.pkuokuo.MQProducer.enums.LoginStatus;
import com.pkuokuo.MQProducer.vo.JSONResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//import com.pkuokuo.kafkademo.kafka.KafkaProducer;

@Controller
@Slf4j
@RequestMapping("/producerkafka")
public class KafkaController {
    @Autowired
    ProducerKafka producerKafka;

    @ResponseBody
    @RequestMapping("/send")
    public JSONResultVo send(HttpServletRequest request) {
        String message = request.getParameter("message");
        log.info("KafkaController_send_message:"+ message);
        producerKafka.sendMessage2(JSON.toJSONString(message));

        return JSONResultVo.result(LoginStatus.SUCCESS,true,null);

    }

}
