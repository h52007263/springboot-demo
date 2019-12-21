package com.hzs.kafka.api;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author hezhensheng
 * @version 1.0
 * @description ConsumerSample
 * @date 2019/12/21 11:23
 */

public class ConsumerSample {
    public static void main(String[] args) {
        String topic = "test-topic";

        Properties props = new Properties();
        // 1.kafka集群
        props.put("bootstrap.servers", "localhost:9092");
        // 2.消费者的分组
        props.put("group.id", "testGroup1");
        // 3.是否开启自动提交offset
        props.put("enable.auto.commit", "true");
        // 4.设置自动提交offset到zookeeper的时间间隔
        props.put("auto.commit.interval.ms", "1000");
        // 5.消息反序列化类型
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        Consumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(topic));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("partition = %d, offset = %d, key = %s, value = %s%n",
                        record.partition(), record.offset(), record.key(), record.value());
            }
        }
    }
}
