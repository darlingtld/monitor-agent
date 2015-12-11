package com.emc.kafka;

import com.alibaba.fastjson.JSON;
import com.emc.pojo.send.Message;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

public class ConsumerMsgTask implements Runnable {
    private KafkaStream kafkaStream;
    private int mThreadNumber;

    public ConsumerMsgTask(KafkaStream stream, int threadNumber) {
        mThreadNumber = threadNumber;
        kafkaStream = stream;
    }

    public void run() {
        ConsumerIterator<byte[], byte[]> it = kafkaStream.iterator();
        while (it.hasNext()) {
            String jsonStr = new String(it.next().message());
            Message message = (Message) JSON.parse(jsonStr);
            System.out.println("*******************Thread " + mThreadNumber + ": " + new String(it.next().message()));
            System.out.println("message type : " + message.getMessageType());
            System.out.println("message details : " + message.getDetails());
        }
        System.out.println("Shutting down Thread: " + mThreadNumber);
    }
}