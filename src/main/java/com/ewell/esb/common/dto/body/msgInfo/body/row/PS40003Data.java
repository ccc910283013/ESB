package com.ewell.esb.common.dto.body.msgInfo.body.row;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Msg")
public class PS40003Data {
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String lastUpdate;
    @XmlAttribute
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

    @Override
    public String toString() {
        return "PS40003Data{" +
                "id='" + id + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", action='" + action + '\'' +
                ", TEMPERATURE='" + TEMPERATURE + '\'' +
                ", SYSTOLIC_PRESSURE='" + SYSTOLIC_PRESSURE + '\'' +
                ", DIASTOLIC_PRESSURE='" + DIASTOLIC_PRESSURE + '\'' +
                ", BREATHING_RATE='" + BREATHING_RATE + '\'' +
                ", PULSE_RATE='" + PULSE_RATE + '\'' +
                ", HEART_RATE='" + HEART_RATE + '\'' +
                ", TTPF='" + TTPF + '\'' +
                ", SIGNS_INFOR_STATUS='" + SIGNS_INFOR_STATUS + '\'' +
                ", ALLERGY_HISTORY='" + ALLERGY_HISTORY + '\'' +
                ", BREAST_FEEDING='" + BREAST_FEEDING + '\'' +
                ", PREGNANCY='" + PREGNANCY + '\'' +
                ", BODY_MASS_INDEX='" + BODY_MASS_INDEX + '\'' +
                ", OUTPUT_AMOUNT='" + OUTPUT_AMOUNT + '\'' +
                ", INPUT_AMOUNT='" + INPUT_AMOUNT + '\'' +
                ", OUTHOSP_INDEX_NO='" + OUTHOSP_INDEX_NO + '\'' +
                ", OUTHOSP_NO='" + OUTHOSP_NO + '\'' +
                ", INHOSP_NUM='" + INHOSP_NUM + '\'' +
                ", PAT_INDEX_NO='" + PAT_INDEX_NO + '\'' +
                ", PAT_NO='" + PAT_NO + '\'' +
                ", SIGNS_RECORD_NO='" + SIGNS_RECORD_NO + '\'' +
                ", WEIGHT='" + WEIGHT + '\'' +
                ", HEIGHT='" + HEIGHT + '\'' +
                ", MEASURE_DATE='" + MEASURE_DATE + '\'' +
                ", INVALID_FLAG='" + INVALID_FLAG + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTEMPERATURE() {
        return TEMPERATURE;
    }

    public void setTEMPERATURE(String TEMPERATURE) {
        this.TEMPERATURE = TEMPERATURE;
    }

    public String getSYSTOLIC_PRESSURE() {
        return SYSTOLIC_PRESSURE;
    }

    public void setSYSTOLIC_PRESSURE(String SYSTOLIC_PRESSURE) {
        this.SYSTOLIC_PRESSURE = SYSTOLIC_PRESSURE;
    }

    public String getDIASTOLIC_PRESSURE() {
        return DIASTOLIC_PRESSURE;
    }

    public void setDIASTOLIC_PRESSURE(String DIASTOLIC_PRESSURE) {
        this.DIASTOLIC_PRESSURE = DIASTOLIC_PRESSURE;
    }

    public String getBREATHING_RATE() {
        return BREATHING_RATE;
    }

    public void setBREATHING_RATE(String BREATHING_RATE) {
        this.BREATHING_RATE = BREATHING_RATE;
    }

    public String getPULSE_RATE() {
        return PULSE_RATE;
    }

    public void setPULSE_RATE(String PULSE_RATE) {
        this.PULSE_RATE = PULSE_RATE;
    }

    public String getHEART_RATE() {
        return HEART_RATE;
    }

    public void setHEART_RATE(String HEART_RATE) {
        this.HEART_RATE = HEART_RATE;
    }

    public String getTTPF() {
        return TTPF;
    }

    public void setTTPF(String TTPF) {
        this.TTPF = TTPF;
    }

    public String getSIGNS_INFOR_STATUS() {
        return SIGNS_INFOR_STATUS;
    }

    public void setSIGNS_INFOR_STATUS(String SIGNS_INFOR_STATUS) {
        this.SIGNS_INFOR_STATUS = SIGNS_INFOR_STATUS;
    }

    public String getALLERGY_HISTORY() {
        return ALLERGY_HISTORY;
    }

    public void setALLERGY_HISTORY(String ALLERGY_HISTORY) {
        this.ALLERGY_HISTORY = ALLERGY_HISTORY;
    }

    public String getBREAST_FEEDING() {
        return BREAST_FEEDING;
    }

    public void setBREAST_FEEDING(String BREAST_FEEDING) {
        this.BREAST_FEEDING = BREAST_FEEDING;
    }

    public String getPREGNANCY() {
        return PREGNANCY;
    }

    public void setPREGNANCY(String PREGNANCY) {
        this.PREGNANCY = PREGNANCY;
    }

    public String getBODY_MASS_INDEX() {
        return BODY_MASS_INDEX;
    }

    public void setBODY_MASS_INDEX(String BODY_MASS_INDEX) {
        this.BODY_MASS_INDEX = BODY_MASS_INDEX;
    }

    public String getOUTPUT_AMOUNT() {
        return OUTPUT_AMOUNT;
    }

    public void setOUTPUT_AMOUNT(String OUTPUT_AMOUNT) {
        this.OUTPUT_AMOUNT = OUTPUT_AMOUNT;
    }

    public String getINPUT_AMOUNT() {
        return INPUT_AMOUNT;
    }

    public void setINPUT_AMOUNT(String INPUT_AMOUNT) {
        this.INPUT_AMOUNT = INPUT_AMOUNT;
    }

    public String getOUTHOSP_INDEX_NO() {
        return OUTHOSP_INDEX_NO;
    }

    public void setOUTHOSP_INDEX_NO(String OUTHOSP_INDEX_NO) {
        this.OUTHOSP_INDEX_NO = OUTHOSP_INDEX_NO;
    }

    public String getOUTHOSP_NO() {
        return OUTHOSP_NO;
    }

    public void setOUTHOSP_NO(String OUTHOSP_NO) {
        this.OUTHOSP_NO = OUTHOSP_NO;
    }

    public String getINHOSP_NUM() {
        return INHOSP_NUM;
    }

    public void setINHOSP_NUM(String INHOSP_NUM) {
        this.INHOSP_NUM = INHOSP_NUM;
    }

    public String getPAT_INDEX_NO() {
        return PAT_INDEX_NO;
    }

    public void setPAT_INDEX_NO(String PAT_INDEX_NO) {
        this.PAT_INDEX_NO = PAT_INDEX_NO;
    }

    public String getPAT_NO() {
        return PAT_NO;
    }

    public void setPAT_NO(String PAT_NO) {
        this.PAT_NO = PAT_NO;
    }

    public String getSIGNS_RECORD_NO() {
        return SIGNS_RECORD_NO;
    }

    public void setSIGNS_RECORD_NO(String SIGNS_RECORD_NO) {
        this.SIGNS_RECORD_NO = SIGNS_RECORD_NO;
    }

    public String getWEIGHT() {
        return WEIGHT;
    }

    public void setWEIGHT(String WEIGHT) {
        this.WEIGHT = WEIGHT;
    }

    public String getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(String HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public String getMEASURE_DATE() {
        return MEASURE_DATE;
    }

    public void setMEASURE_DATE(String MEASURE_DATE) {
        this.MEASURE_DATE = MEASURE_DATE;
    }

    public String getINVALID_FLAG() {
        return INVALID_FLAG;
    }

    public void setINVALID_FLAG(String INVALID_FLAG) {
        this.INVALID_FLAG = INVALID_FLAG;
    }
}
