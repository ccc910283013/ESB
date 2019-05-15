package com.ewell.esb.mq.dto;

import com.ewell.esb.common.util.XmlUtil;
import com.ewell.esb.mq.dto.body.PM02004Info;
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
public class MsgPM02004 {
    @XmlElement(name = "AccessControl")
    private AccessControl accessControl;
    @XmlElement(name = "MessageHeader")
    private MessageHeader messageHeader;
    @XmlElement(name = "MsgInfo")
    private PM02004Info msgInfo;

}
