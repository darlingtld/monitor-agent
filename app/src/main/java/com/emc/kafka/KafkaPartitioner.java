package com.emc.kafka;

/**
 * Created by tangl9 on 2015-10-20.
 */

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

public class KafkaPartitioner implements Partitioner {

    public KafkaPartitioner(VerifiableProperties props) {

    }

    public int partition(Object obj, int numPartitions) {
        int partition = 0;
        if (obj instanceof String) {
            String key = (String) obj;
            partition = key.hashCode() % numPartitions;
        } else {
            partition = obj.toString().length() % numPartitions;
        }
        return partition;
    }
}
