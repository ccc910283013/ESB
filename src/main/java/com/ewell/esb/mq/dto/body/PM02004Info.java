package com.ewell.esb.mq.dto.body;

import com.ewell.esb.mq.dto.body.msgInfo.PM02004Msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MsgInfo")
@XmlAccessorType(XmlAccessType.NONE)
public class PM02004Info {
    @XmlElement
    private PM02004Msg Msg;

    @Override
    public String toString() {
        return "PM02004Info{" +
                "Msg=" + Msg +
                '}';
    }

    public PM02004Msg getMsg() {
        return Msg;
    }

    public void setMsg(PM02004Msg msg) {
        Msg = msg;
    }
}
