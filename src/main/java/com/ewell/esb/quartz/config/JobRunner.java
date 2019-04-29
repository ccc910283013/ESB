package com.ewell.esb.quartz.config;

import com.ewell.esb.quartz.monitor.queue.PM02004;
import com.ewell.esb.quartz.util.ExecutionJob;
import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JobRunner implements ApplicationRunner {

    private static final String JOB_NAME = "TASK_";
    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("--------------------监听队列消息---------------------");
        PM02004.getMsg();
        System.out.println("-----------------------------------------");

    }

    public void abc(){
        System.out.println("--------------------注入定时任务---------------------");

        try {

            JobDetail jobDetail = JobBuilder.newJob(ExecutionJob.class).
                    withIdentity(JOB_NAME + "EventMonitor").build();


            Trigger cronTrigger = TriggerBuilder.newTrigger()
                    .withIdentity(JOB_NAME + "EventMonitor")
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                    .build();
            cronTrigger.getJobDataMap().put("JOB_KEY", new Object());
            ((CronTriggerImpl)cronTrigger).setStartTime(new Date());
            scheduler.scheduleJob(jobDetail,cronTrigger);


        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("--------------------定时任务注入完成---------------------");
    }
}
