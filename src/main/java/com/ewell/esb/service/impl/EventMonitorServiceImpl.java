package com.ewell.esb.service.impl;

import com.ewell.esb.quartz.monitor.EMRSEventMonitor;
import com.ewell.esb.service.EventMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("EventMonitorServiceImpl")
public class EventMonitorServiceImpl implements EventMonitorService {
    @Autowired
    EMRSEventMonitor EMRSEventMonitor;
    @Override
    public void putMsg() {

    }
}
