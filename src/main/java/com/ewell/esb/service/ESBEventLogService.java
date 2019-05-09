package com.ewell.esb.service;

import com.ewell.esb.bean.ESBEventInfo;
import org.aspectj.lang.JoinPoint;

import java.util.List;

public interface ESBEventLogService {
    public boolean esbEventTransDeal(JoinPoint joinPoint,String status);

    public boolean esbEventInsert(ESBEventInfo info);

    public boolean esbEventDeal(String startTime,String endTime);
}
