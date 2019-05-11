package com.ewell.esb.mq.dto.body.msgInfo;

import com.ewell.esb.mq.dto.body.msgInfo.body.PM02004Body;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Msg")
@XmlAccessorType(XmlAccessType.NONE)
public class PM02004Msg {
    @XmlElement
    private PM02004Body body;

    @Override
    public String toString() {
        return "PM02004Msg{" +
                "body=" + body +
                '}';
    }

    public PM02004Body getBody() {
        return body;
    }

    public void setBody(PM02004Body body) {
        this.body = body;
    }
}
