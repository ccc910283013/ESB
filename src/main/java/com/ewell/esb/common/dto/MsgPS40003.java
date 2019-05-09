package com.ewell.esb.common.dto;

import com.ewell.esb.common.dto.body.PM02004Info;
import com.ewell.esb.common.dto.body.PS40003Info;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ESBEntry")
@XmlAccessorType(XmlAccessType.NONE)
public class MsgPS40003 {
    @XmlElement(name = "AccessControl")
    private AccessControl accessControl;
    @XmlElement(name = "MessageHeader")
    private MessageHeader messageHeader;
    @XmlElement(name = "MsgInfo")
    private PS40003Info msgInfo;


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

    @Override
    public String toString() {
        return "MsgPS40003{" +
                "accessControl=" + accessControl +
                ", messageHeader=" + messageHeader +
                ", msgInfo=" + msgInfo +
                '}';
    }

    public PS40003Info getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(PS40003Info msgInfo) {
        this.msgInfo = msgInfo;
    }
}
