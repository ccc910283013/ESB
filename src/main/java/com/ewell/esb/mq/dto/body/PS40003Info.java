package com.ewell.esb.mq.dto.body;

import com.ewell.esb.mq.dto.body.msgInfo.body.row.PS40003Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@Getter
@Setter
@ToString
@XmlRootElement(name = "MsgInfo")
@XmlAccessorType(XmlAccessType.NONE)
public class PS40003Info {
    @XmlElement(name = "Msg")
    private PS40003Data Msg;

}
