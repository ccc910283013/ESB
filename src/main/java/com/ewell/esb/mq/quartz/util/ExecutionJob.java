package com.ewell.esb.mq.quartz.util;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;
@Slf4j
@Async
public class ExecutionJob extends QuartzJobBean{

    @Resource
    private ThreadPoolTaskExecutor executor;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String beanName = (String) jobExecutionContext.getMergedJobDataMap().get("beanName");
        String methodName = (String)jobExecutionContext.getMergedJobDataMap().get("beanMethod");
        Object params = jobExecutionContext.getMergedJobDataMap().get("params");
        try{
            QuartzRunnable task = new QuartzRunnable(beanName, methodName, params);
            Future<?> future = executor.submit(task);
            future.get();
        }catch (Exception e){
            log.error("定时器异常------>"+e.getMessage());
        }

    }
}
