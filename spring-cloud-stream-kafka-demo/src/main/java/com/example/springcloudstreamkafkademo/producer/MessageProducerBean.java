package com.example.springcloudstreamkafkademo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author:Administrator
 * @date:2019/1/22/022
 * 下流
 */
@Component
@EnableBinding(Source.class)//绑定为发送者
public class MessageProducerBean {
    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel messageChannel;  //消息发布链

    @Autowired
    private Source source;

    public void send(String message){
        //通过消息链发送消息
        messageChannel.send(MessageBuilder.withPayload(message).build());
        //通过source发送消息
        //source.output().send(MessageBuilder.withPayload(message).build());
    }
}
