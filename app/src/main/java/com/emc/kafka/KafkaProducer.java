package com.emc.kafka;

import com.alibaba.fastjson.JSONObject;
import com.emc.config.PropertyHolder;
import com.emc.pojo.send.Message;
import com.emc.pojo.send.MessageType;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Properties;

/**
 * Created by tangl9 on 2015-10-20.
 */
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("metadata.broker.list", PropertyHolder.KAFKA_METADATA_BROKER_LIST);
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("key.serializer.class", "kafka.serializer.StringEncoder");
        props.put("partitioner.class", PropertyHolder.KAFKA_PARTITIONER_CLASS);
        /**
         * 0, which means that the producer never waits for an acknowledgement from the broker (the same behavior as 0.7). This option provides the lowest latency but the weakest durability guarantees (some data will be lost when a server fails).
         * 1, which means that the producer gets an acknowledgement after the leader replica has received the data. This option provides better durability as the client waits until the server acknowledges the request as successful (only messages that were written to the now-dead leader but not yet replicated will be lost).
         * -1, which means that the producer gets an acknowledgement after all in-sync replicas have received the data. This option provides the best durability, we guarantee that no messages will be lost as long as at least one in sync replica remains.
         */
        props.put("request.required.acks", PropertyHolder.KAFKA_REQUEST_REQUIRED_ACKS);
        ProducerConfig config = new ProducerConfig(props);

        Producer<String, String> producer = new Producer<>(config);
        // produce messages
        long start = System.currentTimeMillis();
        Message message = new Message();
        message.setTimestamp(new Date());
        message.setMessageType(MessageType.MONITOR_JOB);
        message.setDetails("do something for me");
        String key = message.toString();
        String msg = JSONObject.toJSONString(message);
        // create topic if there does not exist, replication-factor defaults to 1 and partitions defaults to 0
        KeyedMessage<String, String> data = new KeyedMessage<>(PropertyHolder.KAFKA_TOPIC, key, msg);
        logger.info("kafka producer send data {} to topic {}", msg, PropertyHolder.KAFKA_TOPIC);
        producer.send(data);
        System.out.println("time spent:" + (System.currentTimeMillis() - start));
        producer.close();
    }
}
