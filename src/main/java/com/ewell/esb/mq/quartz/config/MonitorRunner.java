package com.ewell.esb.mq.quartz.config;

import com.ewell.esb.common.config.handler.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.*;

@Slf4j
@Component
@Order(value = 1)
public class MonitorRunner implements ApplicationRunner {
    @Value("${Monitor.Enable}")
    private boolean monitorEnable;
    @Value("${Monitor.Queue}")
    private String monitorQueue;
    private Object target;
    private Method method;
    @Override
    public void run(ApplicationArguments args) {
        if (monitorEnable){
            System.out.println("--------------------监听队列消息---------------------");
            List<String> queueList = Arrays.asList(monitorQueue.split(","));
            queueList.forEach(queue ->{
                try {
                    this.target = SpringContextHolder.getBean(queue);
                    this.method = target.getClass().getDeclaredMethod("getMsg");
                    method.invoke(target);
                }catch (Exception e){
                    log.error(queue+"队列不存在");
                }
            });
        }else {
            log.info("监听队列未启动");
        }
    }
}
