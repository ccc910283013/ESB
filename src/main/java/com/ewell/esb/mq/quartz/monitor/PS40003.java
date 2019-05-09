package com.ewell.esb.mq.quartz.monitor;

import com.ewell.esb.bean.ESBEventInfo;
import com.ewell.esb.common.util.DateUtil;
import com.ewell.esb.mq.util.MQFactoryUtil;
import com.ewell.esb.service.ESBEventLogService;
import com.ewell.mq.queue.MessageEntity;
import com.ewell.mq.queue.QueueTools;
import com.ewell.mq.queue.async.EwellMQMutiImpl;
import com.ewell.mq.queue.async.QueueCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Slf4j
@Component
public class PS40003 {
    @Autowired
    private ESBEventLogService esbService;
    private static ESBEventLogService esbServiceTemp;
    @PostConstruct
    public void init(){
        esbServiceTemp = esbService;
    }
    public static void getMsg(){
        QueueTools queueTools = MQFactoryUtil.ps40003;
        EwellMQMutiImpl mutiImpl = queueTools.getMutiMQImpl();
        // 设定操作对象。第一个参数同connect函数为配置文件中队列管理器配置标签名，第二个参数为配置文件中取消息对应对应的标签名。
        mutiImpl.init("QMGR.P63", "PS40003_1");
        log.info("Monitor PS40003 run----------------------");
        // 获取数据
        try {
            mutiImpl.run(new QueueCallback() {
                @Override
                public void onMessage(MessageEntity message) throws Exception {
                    System.out.println(message.getMsg());
                    ESBEventInfo info = new ESBEventInfo();
                    info.setQueueConnectName("QMGR.P63");
                    info.setServiceId("PS40003");
                    info.setQueueSeq("1");
                    info.setMessageId("");
                    info.setMessage(message.getMsg());
                    info.setRecDate(DateUtil.getCurrentTime());
                    System.out.println("---------------");
                    info.setServerIP(MQFactoryUtil.getCUInstance("QMGR.P63").getHostName());
                    info.setLogStatus("1");
                    info.setLogType("1");
                    info.setLastUpdate(DateUtil.getCurrentTime());
                    info.setLogGuid("");
                    info.setServiceName("体征信息推送");
                    esbServiceTemp.esbEventInsert(info);
                }
                @Override
                public void onException(Exception exception) {
                    log.error("PS40003 error:"+exception.getMessage());
                }
            });

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
