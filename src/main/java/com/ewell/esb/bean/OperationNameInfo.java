package com.ewell.esb.bean;

public class OperationNameInfo {
    private String patId;
    private String visitId;
    private String operId;
    private String operationNo;
    //手术名称
    private String operation;
    //手术等级
    private String operationScale;
    //切口等级
    private String woundGrade;

    @Override
    public String toString() {
        return "OperationNameInfo{" +
                "patId='" + patId + '\'' +
                ", visitId='" + visitId + '\'' +
                ", operId='" + operId + '\'' +
                ", operationNo='" + operationNo + '\'' +
                ", operation='" + operation + '\'' +
                ", operationScale='" + operationScale + '\'' +
                ", woundGrade='" + woundGrade + '\'' +
                '}';
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public String getOperationNo() {
        return operationNo;
    }

    public void setOperationNo(String operationNo) {
        this.operationNo = operationNo;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperationScale() {
        return operationScale;
    }

    public void setOperationScale(String operationScale) {
        this.operationScale = operationScale;
    }

    public String getWoundGrade() {
        return woundGrade;
    }

    public void setWoundGrade(String woundGrade) {
        this.woundGrade = woundGrade;
    }
}
