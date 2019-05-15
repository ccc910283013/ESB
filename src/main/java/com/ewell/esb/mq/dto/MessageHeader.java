package com.ewell.esb.mq.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@Getter
@Setter
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MessageHeader")
public class MessageHeader {
    private String Fid;
    private String SourceSysCode;
    private String TargetSysCode;
    private String MsgDate;

}
