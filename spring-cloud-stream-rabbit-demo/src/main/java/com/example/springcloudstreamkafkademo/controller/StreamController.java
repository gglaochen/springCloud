package com.example.springcloudstreamkafkademo.controller;

import com.example.springcloudstreamkafkademo.consumer.MessageConsumerBean;
import com.example.springcloudstreamkafkademo.producer.MessageProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:Administrator
 * @date:2019/1/22/022
 */
@RestController
public class StreamController {
    @Autowired
    private MessageProducerBean messageProducerBean;

    @GetMapping("/send/msg")
    public boolean sendMsg (@RequestParam("message") String message){
        messageProducerBean.send(message);
        return true;
    }
//    @PostMapping("/send/msg")
//    public boolean sendMsg1 (@RequestParam("message") String message){
//        messageProducerBean.send(message);
//        return true;
//    }
}
