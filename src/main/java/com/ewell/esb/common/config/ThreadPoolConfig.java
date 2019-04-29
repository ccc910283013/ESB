package com.ewell.esb.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

//@Configuration
//@EnableConfigurationProperties(ThreadPoolTaskExecutor.class)
public class ThreadPoolConfig {

    @Value("${threadPool.core-pool-size}")
    private int corePoolSize;

    @Value("${threadPool.max-pool-size}")
    private int maxPoolSize;

    @Value("${threadPool.queue-capacity}")
    private int queueCapacity;

    @Value("${threadPool.keep-alive-seconds}")
    private int keepAliveSeconds;

    @Bean
    public ThreadPoolTaskExecutor threadPool(){
        ThreadPoolTaskExecutor threadPools = new ThreadPoolTaskExecutor();
        threadPools.setCorePoolSize(corePoolSize);
        threadPools.setMaxPoolSize(maxPoolSize);
        threadPools.setQueueCapacity(queueCapacity);
        threadPools.setKeepAliveSeconds(keepAliveSeconds);
        threadPools.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return  threadPools;
    }
}
