package com.ewell.esb.common.util;

import com.ewell.esb.bean.ESBEventInfo;

/**
 * 日志处理
 */
public class ProcessLogUtil {
    /**
     * @param info 事件
     * @param logMsg 日志信息
     * @return 拼接字符串
     */
    public static String getEventLogStr(ESBEventInfo info,String logMsg,DealStatusConstant cons){
        return "服务"+info.getServiceId()+"执行"+cons.getText()+",logNo="+info.getLogNo()+"---->"+logMsg;
    }
}
