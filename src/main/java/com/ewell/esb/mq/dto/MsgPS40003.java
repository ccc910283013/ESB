package com.ewell.esb.mq.dto;

import com.ewell.esb.mq.dto.body.PS40003Info;
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
@XmlRootElement(name = "ESBEntry")
@XmlAccessorType(XmlAccessType.NONE)
public class MsgPS40003 {
    @XmlElement(name = "AccessControl")
    private AccessControl accessControl;
    @XmlElement(name = "MessageHeader")
    private MessageHeader messageHeader;
    @XmlElement(name = "MsgInfo")
    private PS40003Info msgInfo;

}
