package com.ewell.esb.mq.util;

import com.ewell.mq.queue.QueueManage;
import com.ewell.mq.queue.QueueTools;
import com.ewell.mq.queue.async.config.ConfigUtil;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQManagedConnection;
import com.ibm.mq.MQQueueManager;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;

public class MQFactoryUtil {
    public static final QueueTools ps40003 = new QueueTools();
    public static final QueueTools pm02004 = new QueueTools();
    private static final ConfigUtil cu = new ConfigUtil();
    /**
     * 读取配置文件信息
     * @param environment 队列管理器名称
     * @return
     */
    public static ConfigUtil getCUInstance(String environment) {
        cu.setEnvironment(environment);
        cu.parseXML();
        return cu;
    }

    public static QueueTools getQueueInstance() {
        return new QueueTools();
    }
}
