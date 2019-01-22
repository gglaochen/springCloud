package com.example.springcloudkafka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:Administrator
 * @date:2019/1/22/022
 */
@RestController
public class KafkaProducerController {
    public final KafkaTemplate<String,String> kafkaTemplate;
    private final String topic;

    public KafkaProducerController(KafkaTemplate<String,String> kafkaTemplate,//作为构造函数的参数时，会自动从spring容器中找，相当于直接AutoWired
                                   @Value("${kafka.topic}") String topic){
        this.kafkaTemplate =kafkaTemplate;
        this.topic = topic;
    }
    @PostMapping("message/send")    //这里只支持Post
    public boolean sendMessage(@RequestParam String message){
        kafkaTemplate.send(topic,message);
        return true;
    }
}
