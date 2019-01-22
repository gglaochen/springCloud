package com.example.springkafka.api;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author:Administrator
 * @date:2019/1/22/022
 * kafka消息发布者
 */
public class KafkaProducerDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","192.168.146.220:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName()); //配置序列化器
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String, String>(properties);
        String topic = "message";   //主题
        Integer partition = 0;      //指定的分区
        long timeMills = System.currentTimeMillis();        //当前系统的毫秒值
        String key = "key-message"; //key
        String value = "value-message";//value
        //创建ProducerRecord
        ProducerRecord<String,String> producerRecord = new ProducerRecord<String, String>(topic,partition,timeMills,key,value);
        //生产消息
        kafkaProducer.send(producerRecord);
        kafkaProducer.close();
    }
}
