package com.ewell.esb.mq.dto.body;

import com.ewell.esb.mq.dto.body.msgInfo.body.row.PS50005Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MsgInfo")
@XmlAccessorType(XmlAccessType.NONE)
public class PS50005Info {
    @XmlElement
    private PS50005Data Msg;

    @Override
    public String toString() {
        return "PS50005Info{" +
                "Msg=" + Msg +
                '}';
    }

    public PS50005Data getMsg() {
        return Msg;
    }

    public void setMsg(PS50005Data msg) {
        Msg = msg;
    }
}
