package com.example.springcloudkafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author:Administrator
 * @date:2019/1/22/022
 */
@Component
public class KafkaConsumerListener {
    @KafkaListener(topics = {"${kafka.topic}"})
    public void getMessage(String message){
        System.out.println("kafka   消费者监听到的消息为:"+message);
    }
}
