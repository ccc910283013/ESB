package com.ewell.esb.mq.dto.body;

import com.ewell.esb.mq.dto.body.msgInfo.body.row.PS40003Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MsgInfo")
@XmlAccessorType(XmlAccessType.NONE)
public class PS40003Info {
    @XmlElement(name = "Msg")
    private PS40003Data Msg;

    @Override
    public String toString() {
        return "PS40003Info{" +
                "Msg=" + Msg +
                '}';
    }

    public PS40003Data getMsg() {
        return Msg;
    }

    public void setMsg(PS40003Data msg) {
        Msg = msg;
    }
}
