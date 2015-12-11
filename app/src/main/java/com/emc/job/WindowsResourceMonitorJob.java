package com.emc.job;

import com.emc.pojo.send.Message;
import com.emc.pojo.send.MessageType;
import com.emc.pojo.send.MonitorInfo;
import com.emc.service.InstanceHolder;
import com.emc.service.impl.WindowsMonitorServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tangl9 on 2015-10-29.
 */
public class WindowsResourceMonitorJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(WindowsResourceMonitorJob.class);

    private WindowsMonitorServiceImpl windowsMonitorService = InstanceHolder.getWindowsMonitorService();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Message message = new Message();
        message.setMessageType(MessageType.MONITOR_JOB);
        MonitorInfo monitorInfo = null;
        try {
            monitorInfo = windowsMonitorService.getMonitorInfo();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            message.setErrorMsg(e.getMessage());
        }
        message.setDetails(monitorInfo);
        logger.info(message.toString());
    }
}
