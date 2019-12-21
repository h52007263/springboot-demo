package com.hzs.kafka.api;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 生产者
 * @date 2019/12/21 11:14
 */

public class ProducerSample {
    public static void main(String[] args) {
        Map<String, Object> props = new HashMap<>();
        // 1.kafka集群，多台服务器用逗号分隔
        props.put("bootstrap.servers", "localhost:9092");
        // 2.消息的序列化类型
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 3.消息的反序列化类型
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // 4.kafka连接zookeeper的url
        props.put("zk.connect", "127.0.0.1:2181");

        String topic = "test-topic";
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        producer.send(new ProducerRecord<String, String>(topic, "idea-key2", "java-message 1"));
        producer.send(new ProducerRecord<String, String>(topic, "idea-key2", "java-message 2"));
        producer.send(new ProducerRecord<String, String>(topic, "idea-key2", "java-message 3"));

        producer.close();


    }
}
