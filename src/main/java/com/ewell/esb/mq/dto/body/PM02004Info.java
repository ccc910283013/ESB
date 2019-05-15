package com.ewell.esb.mq.dto.body;

import com.ewell.esb.mq.dto.body.msgInfo.PM02004Msg;
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
public class PM02004Info {
    @XmlElement
    private PM02004Msg Msg;


}
