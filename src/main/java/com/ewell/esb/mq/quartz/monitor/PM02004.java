package com.ewell.esb.mq.quartz.monitor;
import com.ewell.esb.bean.ESBEventInfo;
import com.ewell.esb.common.util.DateUtil;
import com.ewell.esb.mq.util.MQFactoryUtil;
import com.ewell.esb.mq.service.ESBEventLogService;
import com.ewell.mq.queue.MessageEntity;
import com.ewell.mq.queue.QueueTools;
import com.ewell.mq.queue.async.EwellMQMutiImpl;
import com.ewell.mq.queue.async.QueueCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.URL;

@Component
@Slf4j
public class PM02004 {
    @Autowired
    private ESBEventLogService esbService;
    private static ESBEventLogService esbServiceTemp;
    @PostConstruct
    public void init(){
        esbServiceTemp = esbService;
    }
    public static void getMsg(){
        QueueTools queueTools = MQFactoryUtil.pm02004;
        EwellMQMutiImpl mutiImpl = queueTools.getMutiMQImpl();
        // 设定操作对象。第一个参数同connect函数为配置文件中队列管理器配置标签名，第二个参数为配置文件中取消息对应对应的标签名。
        mutiImpl.init("QMGR.P63", "PM02004_1");
        log.info("Monitor PM02004 run----------------------");
        // 获取数据
        try {
            mutiImpl.run(new QueueCallback() {
                @Override
                public void onMessage(MessageEntity message) throws Exception {
                    System.out.println(message.getMsg());
                    ESBEventInfo info = new ESBEventInfo();
                    info.setQueueConnectName("QMGR.P63");
                    info.setServiceId("PM02004");
                    info.setQueueSeq("1");
                    info.setMessageId("");
                    info.setMessage(message.getMsg());
                    info.setRecDate(DateUtil.getCurrentTime());
                    //System.out.println("---------------");
                    info.setServerIP(MQFactoryUtil.getCUInstance("QMGR.P63").getHostName());
                    info.setLogStatus("1");
                    info.setLogType("1");
                    info.setLastUpdate(DateUtil.getCurrentTime());
                    info.setLogGuid("");
                    info.setServiceName("职工字典同步");
                    esbServiceTemp.esbEventInsert(info);
                }
                @Override
                public void onException(Exception exception) {
                    log.error("PM02004 error:"+exception.getMessage());
                }
            });

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    //验证包文件冲突
    public static void main(String[] args) throws Exception {
        URL urlOfClass = PM02004.class.getClassLoader().getResource("org/springframework/boot/web/servlet/support/SpringBootServletInitializer.class" +
                "");
        System.out.println(urlOfClass);
        //URL a = ClassLoader.getSystemResource("D:\\EWELL\\conf.properties");
        //System.out.println(ClassLoader.getSystemClassLoader());
    }

}
