package com.ewell.esb.mq.dto.body.msgInfo.body.row;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;
@Getter
@Setter
@ToString
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "msg")
public class PS40003Data {
    private String id;
    private String lastUpdate;
    private String action;
    @XmlElement
    private String TEMPERATURE;
    @XmlElement
    private String SYSTOLIC_PRESSURE;
    @XmlElement
    private String DIASTOLIC_PRESSURE;
    @XmlElement
    private String BREATHING_RATE;
    @XmlElement
    private String PULSE_RATE;
    @XmlElement
    private String HEART_RATE;
    @XmlElement
    private String TTPF;
    @XmlElement
    private String SIGNS_INFOR_STATUS;
    @XmlElement
    private String ALLERGY_HISTORY;
    @XmlElement
    private String BREAST_FEEDING;
    @XmlElement
    private String PREGNANCY;
    @XmlElement
    private String BODY_MASS_INDEX;
    @XmlElement
    private String OUTPUT_AMOUNT;
    @XmlElement
    private String INPUT_AMOUNT;
    @XmlElement
    private String OUTHOSP_INDEX_NO;
    @XmlElement
    private String OUTHOSP_NO;
    @XmlElement
    private String INHOSP_NUM;
    @XmlElement
    private String PAT_INDEX_NO;
    @XmlElement
    private String PAT_NO;
    @XmlElement
    private String SIGNS_RECORD_NO;
    @XmlElement
    private String WEIGHT;
    @XmlElement
    private String HEIGHT;
    @XmlElement
    private String MEASURE_DATE;
    @XmlElement
    private String INVALID_FLAG;


}
