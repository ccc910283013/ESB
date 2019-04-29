package com.ewell.esb.quartz.monitor.queue;
import com.ewell.esb.bean.StaffInfo;
import com.ewell.esb.common.dto.MsgPM02004;
import com.ewell.esb.common.util.MQFactoryUtil;
import com.ewell.esb.common.util.XmlUtil;
import com.ewell.esb.service.HISEventDealService;
import com.ewell.esb.service.impl.HISEventDealServiceImpl;
import com.ewell.mq.queue.MessageEntity;
import com.ewell.mq.queue.QueueTools;
import com.ewell.mq.queue.async.EwellMQMutiImpl;
import com.ewell.mq.queue.async.QueueCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PM02004 {
    @Autowired
    private HISEventDealService hisService;
    private static HISEventDealService hisServiceTemp;
    @PostConstruct
    public void init(){
        hisServiceTemp = hisService;
    }
    private static final Logger logger = LoggerFactory.getLogger(PM02004.class);
    public static void getMsg(){

        QueueTools queueTools = MQFactoryUtil.getInstance();
        EwellMQMutiImpl mutiImpl = queueTools.getMutiMQImpl();
        // 设定操作对象。第一个参数同connect函数为配置文件中队列管理器配置标签名，第二个参数为配置文件中取消息对应对应的标签名。
        mutiImpl.init("QMGR.P63", "PM02004_1");
        System.out.println("Monitor PM02004 run----------------------");
        // 获取数据
        try {
            mutiImpl.run(new QueueCallback() {
                @Override
                public void onMessage(MessageEntity message) throws Exception {
                    MsgPM02004 xmlObject = XmlUtil.xmlToJavaBean(MsgPM02004.class,message.getMsg());
                    StaffInfo staff = new StaffInfo();
                    staff.setDeptCode(xmlObject.getMsgInfo().getMsg().getBody().getRow().getSUBOR_DEPT_CODE());
                    staff.setDeptCodeOld(xmlObject.getMsgInfo().getMsg().getBody().getRow().getSUBOR_DEPT_CODE_OLD());
                    staff.setEmpName(xmlObject.getMsgInfo().getMsg().getBody().getRow().getSTAFF_NAME());
                    staff.setEmpNo(xmlObject.getMsgInfo().getMsg().getBody().getRow().getSTAFF_INDEX_NO());
                    staff.setJob(xmlObject.getMsgInfo().getMsg().getBody().getRow().getSTAFF_CATEG_NAME());
                    staff.setUserId("");
                    System.out.println(staff.toString());
                    boolean flag = hisServiceTemp.modifyUserGrant(staff,"update");
                    logger.info(staff.getEmpName()+"从"+staff.getDeptCodeOld()+"转入"+staff.getDeptCode()+"成功");
                    System.out.println("onMessage over,status is"+flag);
                }
                @Override
                public void onException(Exception exception) {
                    logger.error(exception.getMessage());
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    public static void main(String[] args) throws Exception {
        QueueTools queueTools = new QueueTools();
        EwellMQMutiImpl mutiImpl = queueTools.getMutiMQImpl();
        // 设定操作对象。第一个参数同connect函数为配置文件中队列管理器配置标签名，第二个参数为配置文件中取消息对应对应的标签名。
        mutiImpl.init("QMGR.P63", "PM02004_1");
        // 获取数据
        try {
            mutiImpl.run(new QueueCallback() {
                @Override
                public void onMessage(MessageEntity message) throws Exception {
                    System.out.println("onMessage over"+message.getMsg());

                    // 可在此处加入业务逻辑，如XML解析并入库。也可将取到的消息内容放入容器，自行处理。
                }

                @Override
                public void onException(Exception exception) {
                    // 可在此处加入异常处理
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
*/
}
