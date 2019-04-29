package com.ewell.esb.quartz.util;

import com.ewell.esb.bean.EMRSEventInfo;
import com.ewell.esb.quartz.monitor.EMRSEventMonitor;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Async
public class ExecutionJob extends QuartzJobBean{

    @Autowired
    private EMRSEventMonitor emrs;
    //@Autowired
    //private Scheduler scheduler;
    @Autowired
    private ThreadPoolTaskExecutor executor;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //String beanName = (String) jobExecutionContext.getMergedJobDataMap().get("beanName");
        //String methodName = (String)jobExecutionContext.getMergedJobDataMap().get("methodName");
        //String params = (String)jobExecutionContext.getMergedJobDataMap().get("params");
        try{
            System.out.println("执行成功");
            //QuartzRunnable task = new QuartzRunnable(beanName, methodName, params);
            Future<?> future = executor.submit(emrs);
            String abc = (String) future.get();
            System.out.println(abc);
            System.out.println("-------------------");
            //List<EMRSEventInfo> l = (List<EMRSEventInfo>)future.get();
            //for (int i = 0;i<l.size();i++){
                //System.out.println(l.get(i).toString());
            //}
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
