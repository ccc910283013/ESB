package com.ewell.esb.mq.service;

import com.ewell.esb.bean.ESBEventInfo;
import com.ewell.esb.common.util.DealStatusConstant;
import org.aspectj.lang.JoinPoint;

import java.util.List;

public interface ESBEventLogService {
    public boolean esbEventTransDeal(JoinPoint joinPoint,DealStatusConstant con);

    public boolean esbEventInsert(ESBEventInfo info);

    public boolean esbEventDeal(String currentTime);
}
