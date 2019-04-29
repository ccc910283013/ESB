package com.ewell.esb.common.util;

import com.ewell.mq.queue.QueueTools;

public class MQFactoryUtil {
    private static QueueTools qt;
    public static QueueTools getInstance(){
        if (qt == null){
            qt = new QueueTools();
        }
        return qt;
    }

}
