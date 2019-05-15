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
@XmlRootElement(name = "AccessControl")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessControl {
    private String UserName;
    private String Password;
    private String Fid;

}
