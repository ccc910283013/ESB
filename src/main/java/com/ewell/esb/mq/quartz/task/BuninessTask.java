package com.ewell.esb.mq.quartz.task;

import com.ewell.esb.common.util.DateUtil;
import com.ewell.esb.mq.service.ESBEventLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@Component(value = "BuninessTask")
public class BuninessTask {
    private static Date date = null;
    @Resource
    private ESBEventLogService esbService;
    public void taskMonitorEvent() throws Exception{
        date = new Date();
        //log.info("in-------------------------------"+DateUtil.getCurrentTime()+" "+Thread.currentThread());
        Boolean flag = esbService.esbEventDeal(DateUtil.timeStampToDate(date.getTime()));
        //log.info("exit-------------------------------"+DateUtil.getCurrentTime()+" "+Thread.currentThread());
    }
}
