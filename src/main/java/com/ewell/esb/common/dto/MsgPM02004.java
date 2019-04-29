package com.ewell.esb.common.dto;

import com.ewell.esb.common.dto.body.PM02004Info;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ESBEntry")
@XmlAccessorType(XmlAccessType.NONE)
public class MsgPM02004 {
    @XmlElement(name = "AccessControl")
    private AccessControl accessControl;
    @XmlElement(name = "MessageHeader")
    private MessageHeader messageHeader;
    @XmlElement(name = "MsgInfo")
    private PM02004Info msgInfo;

    @Override
    public String toString() {
        return "MsgPM02004{" +
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

    public PM02004Info getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(PM02004Info msgInfo) {
        this.msgInfo = msgInfo;
    }
}
