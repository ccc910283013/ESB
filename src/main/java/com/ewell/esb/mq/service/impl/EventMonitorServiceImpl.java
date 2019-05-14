package com.ewell.esb.mq.service.impl;

import com.ewell.esb.mq.quartz.monitor.EMRSEventMonitor;
import com.ewell.esb.mq.service.EventMonitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("EventMonitorServiceImpl")
public class EventMonitorServiceImpl implements EventMonitorService {
    @Resource
    private EMRSEventMonitor EMRSEventMonitor;
    @Override
    public void putMsg() {

    }
}
