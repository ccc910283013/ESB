package com.ewell.esb.quartz.monitor;

import com.ewell.esb.bean.EMRSEventInfo;
import com.ewell.esb.dao.EMRSEventInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Callable;
@Component
public class EMRSEventMonitor implements Callable,Serializable {
    @Autowired
    EMRSEventInfoDao dao;
    @Override
    public String call()  {
        System.out.println(Thread.currentThread().getName() + "....");
        List<EMRSEventInfo> l = dao.findAllEvent();
        System.out.println(l.size());
        return "haha";
    }
}
