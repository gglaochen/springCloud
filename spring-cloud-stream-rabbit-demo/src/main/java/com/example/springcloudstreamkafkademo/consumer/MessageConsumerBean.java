package com.example.springcloudstreamkafkademo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

/**
 * @author:Administrator
 * @date:2019/1/22/022
 * 上流
 * 3种订阅方式
 */
@Component
@EnableBinding({Sink.class})//绑定为接收器
public class MessageConsumerBean {
    @Autowired
    @Qualifier(Sink.INPUT)
    private SubscribableChannel subscribableChannel;//接受链
    //1.当subscribableChannel注入完成后完成回调
    @PostConstruct
    public void init(){
        subscribableChannel.subscribe(message -> System.out.println(message.getPayload()));
    }
    //2.@ServiceActivator表示有消息过来就会激活该方法
    @ServiceActivator(inputChannel = Sink.INPUT)
    public void message(String messaeg){
        System.out.println("@ServiceActivator:"+messaeg);
    }
    //3.@StreamListener监听流,最常用
    @StreamListener(Sink.INPUT)
    public void onmessage(String message){
        System.out.println(" @StreamListener:"+message);
    }
}
