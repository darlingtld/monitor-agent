package com.emc.controller;

import com.emc.job.HeartBeatJob;
import com.emc.job.WindowsResourceMonitorJob;
import com.emc.sheduler.QuartzManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan({"com.emc.*"})
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        logger.info("application started");

        QuartzManager.addJob("HEART_BEAT_JOB", HeartBeatJob.class, "0/2 * * * * ?");

        QuartzManager.addJob("WINDOWS_RESOURCE_USAGE", WindowsResourceMonitorJob.class,"0/10 * * * * ?");

    }

}