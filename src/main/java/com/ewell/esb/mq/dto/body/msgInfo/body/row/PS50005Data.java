package com.ewell.esb.mq.dto.body.msgInfo.body.row;

import com.ewell.esb.common.util.XmlUtil;
import com.ewell.esb.mq.dto.MsgPS50005;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;
@Getter
@Setter
@ToString
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "msg")
public class PS50005Data {
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String lastUpdate;
    @XmlAttribute
    private String action;
    @XmlElement
    private String PATIENT_ID;
    @XmlElement
    private String VISIT_ID;
    @XmlElement
    private String OPER_ID;
    @XmlElement
    private String OPERATION_NO;
    @XmlElement
    private String OPERATION;
    @XmlElement
    private String OPERATION_SCALE;
    @XmlElement
    private String WOUND_GRADE;


}
