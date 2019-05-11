package com.ewell.esb.mq.dto.body.msgInfo.body.row;

import javax.xml.bind.annotation.*;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSTAFF_INDEX_NO() {
        return STAFF_INDEX_NO;
    }

    public void setSTAFF_INDEX_NO(String STAFF_INDEX_NO) {
        this.STAFF_INDEX_NO = STAFF_INDEX_NO;
    }

    public String getSTAFF_NAME() {
        return STAFF_NAME;
    }

    public void setSTAFF_NAME(String STAFF_NAME) {
        this.STAFF_NAME = STAFF_NAME;
    }

    public String getEDUCATION_NAME() {
        return EDUCATION_NAME;
    }

    public void setEDUCATION_NAME(String EDUCATION_NAME) {
        this.EDUCATION_NAME = EDUCATION_NAME;
    }

    public String getSTAFF_CATEG_NAME() {
        return STAFF_CATEG_NAME;
    }

    public void setSTAFF_CATEG_NAME(String STAFF_CATEG_NAME) {
        this.STAFF_CATEG_NAME = STAFF_CATEG_NAME;
    }

    public String getSUBOR_DEPT_CODE() {
        return SUBOR_DEPT_CODE;
    }

    public void setSUBOR_DEPT_CODE(String SUBOR_DEPT_CODE) {
        this.SUBOR_DEPT_CODE = SUBOR_DEPT_CODE;
    }

    public String getMAJOR_SKILL_POST_NAME() {
        return MAJOR_SKILL_POST_NAME;
    }

    public void setMAJOR_SKILL_POST_NAME(String MAJOR_SKILL_POST_NAME) {
        this.MAJOR_SKILL_POST_NAME = MAJOR_SKILL_POST_NAME;
    }

    public String getSUBOR_DEPT_CODE_OLD() {
        return SUBOR_DEPT_CODE_OLD;
    }

    public void setSUBOR_DEPT_CODE_OLD(String SUBOR_DEPT_CODE_OLD) {
        this.SUBOR_DEPT_CODE_OLD = SUBOR_DEPT_CODE_OLD;
    }

    public String getUPDATE_DATE() {
        return UPDATE_DATE;
    }

    public void setUPDATE_DATE(String UPDATE_DATE) {
        this.UPDATE_DATE = UPDATE_DATE;
    }

    @Override
    public String toString() {
        return "PM02004Data{" +
                "action='" + action + '\'' +
                ", STAFF_INDEX_NO='" + STAFF_INDEX_NO + '\'' +
                ", STAFF_NAME='" + STAFF_NAME + '\'' +
                ", EDUCATION_NAME='" + EDUCATION_NAME + '\'' +
                ", STAFF_CATEG_NAME='" + STAFF_CATEG_NAME + '\'' +
                ", SUBOR_DEPT_CODE='" + SUBOR_DEPT_CODE + '\'' +
                ", MAJOR_SKILL_POST_NAME='" + MAJOR_SKILL_POST_NAME + '\'' +
                ", SUBOR_DEPT_CODE_OLD='" + SUBOR_DEPT_CODE_OLD + '\'' +
                ", UPDATE_DATE='" + UPDATE_DATE + '\'' +
                '}';
    }
}
