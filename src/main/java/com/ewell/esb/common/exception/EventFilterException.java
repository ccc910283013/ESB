package com.ewell.esb.common.exception;

import com.ewell.esb.bean.ESBEventInfo;

import java.util.HashMap;


public class EventFilterException extends RuntimeException{

    public EventFilterException(ESBEventInfo info,String errorMessage) {
        super(getMessage(info,errorMessage));
    }
    private static String getMessage(ESBEventInfo info,String errorMessage){
        return info.getServiceId()+"执行失败,logNo="+info.getLogNo()+"---->"+errorMessage;
    }
}
