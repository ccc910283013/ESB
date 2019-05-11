package com.ewell.esb.mq;

import com.ewell.esb.mq.dto.MessageEntity;
import com.ewell.esb.mq.util.MQFactoryUtil;
import com.ewell.mq.queue.QueueTools;
import com.ibm.mq.MQException;
import com.ibm.mq.MQQueueManager;

public class BSPutAndGet {
    Boolean status = Boolean.FALSE;
    MQQueueManager mm = null;
    public MessageEntity PutAndGet(String gateKeeper,String mqMsg) throws Exception {
        QueueTools qt = MQFactoryUtil.getQueueInstance();
        MessageEntity me = new MessageEntity();
        try{

            //ConfigUtil cu = new ConfigUtil();
            //cu.setEnvironment("QMGR.S63");
            mm = qt.connect(gateKeeper);
            /*
            String str = "    <ESBEntry>\n" +
                    "      <AccessControl>\n" +
                    "        <UserName>CPOE</UserName>\n" +
                    "        <Password>123456</Password>\n" +
                    "        <Fid>BS10045</Fid>\n" +
                    "      </AccessControl>\n" +
                    "      <MessageHeader>\n" +
                    "        <Fid>BS10045</Fid>\n" +
                    "        <SourceSysCode>S63</SourceSysCode>\n" +
                    "        <TargetSysCode>S00</TargetSysCode>\n" +
                    "        <MsgDate>2019041619385945</MsgDate>\n" +
                    "      </MessageHeader>\n" +
                    "      <MsgInfo>\n" +
                    "<query item=\"PATIENT_UID\" compy=\"=\" value=\"'20190415084612724'\" splice=\"and\"/>\n" +
                    "      </MsgInfo>\n" +
                    "    </ESBEntry>";
                    */

            System.out.println(mqMsg);
            String msgId = qt.putMsg(mm,"BS10045",mqMsg);
            String str1 = qt.getMsgById(mm,"BS10045","1",msgId,30);
            //status = qt.putMsgWithId(mm,"BS10045","0",str, msgId);
            me.setCode(true);
            me.setMessage(str1);
            return me;
        }catch (Exception e) {
            throw e;
        }finally {
            if (null != mm) {
                try {
                    mm.disconnect();
                } catch (MQException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
