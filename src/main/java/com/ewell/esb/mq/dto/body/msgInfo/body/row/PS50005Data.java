package com.ewell.esb.mq.dto.body.msgInfo.body.row;

import javax.xml.bind.annotation.*;

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

    @Override
    public String toString() {
        return "PS50005Data{" +
                "id='" + id + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", action='" + action + '\'' +
                ", PATIENT_ID='" + PATIENT_ID + '\'' +
                ", VISIT_ID='" + VISIT_ID + '\'' +
                ", OPER_ID='" + OPER_ID + '\'' +
                ", OPERATION_NO='" + OPERATION_NO + '\'' +
                ", OPERATION='" + OPERATION + '\'' +
                ", OPERATION_SCALE='" + OPERATION_SCALE + '\'' +
                ", WOUND_GRADE='" + WOUND_GRADE + '\'' +
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

    public String getPATIENT_ID() {
        return PATIENT_ID;
    }

    public void setPATIENT_ID(String PATIENT_ID) {
        this.PATIENT_ID = PATIENT_ID;
    }

    public String getVISIT_ID() {
        return VISIT_ID;
    }

    public void setVISIT_ID(String VISIT_ID) {
        this.VISIT_ID = VISIT_ID;
    }

    public String getOPER_ID() {
        return OPER_ID;
    }

    public void setOPER_ID(String OPER_ID) {
        this.OPER_ID = OPER_ID;
    }

    public String getOPERATION_NO() {
        return OPERATION_NO;
    }

    public void setOPERATION_NO(String OPERATION_NO) {
        this.OPERATION_NO = OPERATION_NO;
    }

    public String getOPERATION() {
        return OPERATION;
    }

    public void setOPERATION(String OPERATION) {
        this.OPERATION = OPERATION;
    }

    public String getOPERATION_SCALE() {
        return OPERATION_SCALE;
    }

    public void setOPERATION_SCALE(String OPERATION_SCALE) {
        this.OPERATION_SCALE = OPERATION_SCALE;
    }

    public String getWOUND_GRADE() {
        return WOUND_GRADE;
    }

    public void setWOUND_GRADE(String WOUND_GRADE) {
        this.WOUND_GRADE = WOUND_GRADE;
    }
}
