package com.ewell.esb.mq.quartz.config;

import com.ewell.esb.mq.quartz.util.ExecutionJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Slf4j
@Component
@Order(value = 2)
public class JobRunner implements ApplicationRunner {
    private Properties properties = new Properties();
    @Value("${job.Enable}")
    private boolean jobEnable;
    @Value("${job.Context}")
    private String jobContext;
    @Autowired
    Environment environment;
    private Object target;
    private Method method;
    private static final String JOB_NAME = "TASK_";
    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("--------------------注入定时任务---------------------");
        if (true ==jobEnable){
            List<String> taskList = Arrays.asList(jobContext.split(","));
            taskList.forEach(task ->{
                Boolean flag = environment.getProperty("job."+task+".Enable",Boolean.class);
                if (flag == true){
                    QuartzJobConfig jobConfig = QuartzJobConfig.getInstance(task);
                    String cronExpression = environment.getProperty("job."+task+".cronExpression");
                    try {
                        JobDetail jobDetail = JobBuilder.newJob(ExecutionJob.class).
                                withIdentity(JOB_NAME + task).build();
                        Trigger cronTrigger = TriggerBuilder.newTrigger()
                                .withIdentity(JOB_NAME + task)
                                .startNow()
                                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                                .build();
                        JobDataMap jmap = cronTrigger.getJobDataMap();
                        jmap.put("beanName",jobConfig.getBeanName());
                        jmap.put("beanMethod",jobConfig.getMethodName());
                        jmap.put("params",jobConfig.getParams());
                        ((CronTriggerImpl)cronTrigger).setStartTime(new Date());
                        scheduler.scheduleJob(jobDetail,cronTrigger);
                    } catch (Exception e){
                        log.error(task +" error:"+e.getMessage());
                    }
                }else{
                    log.info(task+"定时任务未开启");
                }
            });
        }else{
            log.info("定时任务未开启");
        }
        System.out.println("--------------------定时任务注入完成---------------------");


    }

}
