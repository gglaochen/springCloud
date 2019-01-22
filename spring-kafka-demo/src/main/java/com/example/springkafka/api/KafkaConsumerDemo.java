package com.example.springkafka.api;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author:Administrator
 * @date:2019/1/22/022
 * kafka消息订阅者
 */
public class KafkaConsumerDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","192.168.146.220:9092");
        properties.setProperty("key.deserializer", StringDeserializer.class.getName()); //配置反序列化器
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());
        properties.setProperty("group.id","group-1");
        //创建kafka消费者对象
        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
        //让消费者订阅kafka主题,这里是集合，一个消费者可以订阅多个主题
        kafkaConsumer.subscribe(Arrays.asList("message"));
        while (true) {
        ConsumerRecords<String, String> records = kafkaConsumer.poll(1000);//1秒拉一次消息
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("--------offset = %d,key = %s,value = %s\n", record.offset(), record.key(), record.value());
        }
    }
}
