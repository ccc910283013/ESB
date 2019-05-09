package com.ewell.esb.mq.quartz.task;

import com.ewell.esb.bean.EMRSEventInfo;
import com.ewell.esb.bean.ESBEventInfo;
import com.ewell.esb.common.aop.EventDeal;
import com.ewell.esb.common.util.DateUtil;
import com.ewell.esb.service.ESBEventLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Slf4j
@Component(value = "BuninessTask")
public class BuninessTask {
    @Value("${job.ESBEventMonitor.timeInterval}")
    private int timeInterval;
    private Date date;
    @Autowired
    ESBEventLogService esbService;
    public void taskMonitorEvent(){
        date = new Date();
        log.info("taskMonitorEvent in-------------------------------"+DateUtil.getCurrentTime()+" "+Thread.currentThread());
        String startTime = DateUtil.timeStampToDate(DateUtil.addSecondToDate(date,-timeInterval).getTime());
        String endTime = DateUtil.timeStampToDate(date.getTime());
        Boolean flag = esbService.esbEventDeal(startTime,endTime);
        log.info("taskMonitorEvent exit-------------------------------"+DateUtil.getCurrentTime()+" "+Thread.currentThread());
    }
}
