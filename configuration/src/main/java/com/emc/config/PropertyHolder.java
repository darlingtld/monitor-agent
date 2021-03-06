package com.emc.config;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by tangl9 on 2015-10-20.
 */
public class PropertyHolder {

    private static Properties prop = new Properties();

    static {
        try {
            prop.load(PropertyHolder.class.getClassLoader().getResourceAsStream("app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String KAFKA_ZOOKEEPER = prop.getProperty("kafka.zookeeper");
    public static final String KAFKA_SERVER0 = prop.getProperty("kafka.server0");
    public static final String KAFKA_SERVER1 = prop.getProperty("kafka.server1");
    public static final String KAFKA_SERVER2 = prop.getProperty("kafka.server2");
    public static final String KAFKA_METADATA_BROKER_LIST = prop.getProperty("kafka.metadata.broker.list");
    public static final String KAFKA_PARTITIONER_CLASS = prop.getProperty("kafka.partitioner.class");
    public static final String KAFKA_REQUEST_REQUIRED_ACKS = prop.getProperty("kafka.request.required.acks");
    public static final String KAFKA_TOPIC = prop.getProperty("kafka.topic");
    public static final String KAFKA_GROUP = prop.getProperty("kafka.group");
    public static final Integer KAFKA_CONSUMER_THREAD_NUMBER = Integer.parseInt(prop.getProperty("kafka.consumer.thread.number"));
    public static final String ZOOKEEPER_SESSION_TIMEOUT_MS = prop.getProperty("zookeeper.session.timeout.ms");
    public static final String ZOOKEEPER_SYNC_TIME_MS = prop.getProperty("zookeeper.sync.time.ms");
    public static final String AUTO_COMMIT_INTERVAL_MS = prop.getProperty("auto.commit.interval.ms");

}
