package com.emc.job;

import com.emc.pojo.send.Message;
import com.emc.pojo.send.MessageType;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by tangl9 on 2015-10-29.
 */
public class HeartBeatJob implements Job {

    private static Logger logger = LoggerFactory.getLogger(HeartBeatJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Message message = new Message();
        message.setTimestamp(new Date());
        message.setMessageType(MessageType.HEART_BEAT);
        message.setDetails("i am alive");
        logger.info(message.toString());
//        push to kafka
    }
}
