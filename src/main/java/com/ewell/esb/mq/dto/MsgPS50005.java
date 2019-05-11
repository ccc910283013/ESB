package com.ewell.esb.mq.dto;

import com.ewell.esb.common.util.StringUtils;
import com.ewell.esb.common.util.XmlUtil;
import com.ewell.esb.mq.dto.body.PS50005Info;
import com.ewell.esb.mq.quartz.monitor.PM02004;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ESBEntry")
@XmlAccessorType(XmlAccessType.NONE)
public class MsgPS50005 {
    @XmlElement(name = "AccessControl")
    private AccessControl accessControl;
    @XmlElement(name = "MessageHeader")
    private MessageHeader messageHeader;
    @XmlElement(name = "MsgInfo")
    private PS50005Info msgInfo;

    @Override
    public String toString() {
        return "MsgPS50005{" +
                "accessControl=" + accessControl +
                ", messageHeader=" + messageHeader +
                ", msgInfo=" + msgInfo +
                '}';
    }

    public AccessControl getAccessControl() {
        return accessControl;
    }

    public void setAccessControl(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }

    public PS50005Info getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(PS50005Info msgInfo) {
        this.msgInfo = msgInfo;
    }


}
