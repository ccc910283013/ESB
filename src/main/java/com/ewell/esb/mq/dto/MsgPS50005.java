package com.ewell.esb.mq.dto;

import com.ewell.esb.common.util.StringUtils;
import com.ewell.esb.common.util.XmlUtil;
import com.ewell.esb.mq.dto.body.PS50005Info;
import com.ewell.esb.mq.quartz.monitor.PM02004;
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
public class MsgPS50005 {
    @XmlElement(name = "AccessControl")
    private AccessControl accessControl;
    @XmlElement(name = "MessageHeader")
    private MessageHeader messageHeader;
    @XmlElement(name = "MsgInfo")
    private PS50005Info msgInfo;




}
