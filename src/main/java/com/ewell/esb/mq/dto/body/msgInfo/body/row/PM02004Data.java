package com.ewell.esb.mq.dto.body.msgInfo.body.row;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;
@Getter
@Setter
@ToString
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "row")
public class PM02004Data{
    @XmlAttribute
    private String action;
    @XmlElement
    private String STAFF_INDEX_NO;
    @XmlElement
    private String STAFF_NAME;
    @XmlElement
    private String EDUCATION_NAME;
    @XmlElement
    private String STAFF_CATEG_NAME;
    @XmlElement
    private String SUBOR_DEPT_CODE;
    @XmlElement
    private String MAJOR_SKILL_POST_NAME;
    @XmlElement
    private String SUBOR_DEPT_CODE_OLD;
    @XmlElement
    private String UPDATE_DATE;


}
