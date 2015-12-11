package com.emc.scheduler;

/**
 * Created by tangl9 on 2015-10-29.
 */

import com.emc.sheduler.QuartzManager;

public class QuartzTest {
    public static void main(String[] args) {
        try {
            String jobName = "job name";
            System.out.println("[system start] every 1 second...");
            QuartzManager.addJob(jobName, QuartzJob.class, "0/1 * * * * ?");

            Thread.sleep(5000);
            System.out.println("[modify schedule] every 2 seconds...");
            QuartzManager.modifyJobTime(jobName, "*/2 * * * * ?");
            Thread.sleep(6000);
            System.out.println("[remove job] ...");
            QuartzManager.removeJob(jobName);
            System.out.println("[remove job] successfully");

            System.out.println("[add job] every 10 seconds...");
            QuartzManager.addJob(jobName, QuartzJob.class, "*/10 * * * * ?");
            Thread.sleep(60000);
            System.out.println("[remove job] ...");
            QuartzManager.removeJob(jobName);
            System.out.println("[remove job] successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

