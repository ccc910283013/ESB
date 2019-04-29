package com.ewell.esb.bean;

public class EMRSEventInfo {
    private String eventId;
    private String patientId;
    private String sendingApp;
    private String areaCode;
    private String patientClass;
    private String visitId;
    private String eventObject;
    private String objectClass;
    private String eventType;
    private String eventKey;
    private String operatorId;
    private String operatorName;
    private String operationTime;
    private String eventStatus;
    private String sessionId;
    private String eventTime;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getSendingApp() {
        return sendingApp;
    }

    public void setSendingApp(String sendingApp) {
        this.sendingApp = sendingApp;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPatientClass() {
        return patientClass;
    }

    public void setPatientClass(String patientClass) {
        this.patientClass = patientClass;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getEventObject() {
        return eventObject;
    }

    public void setEventObject(String eventObject) {
        this.eventObject = eventObject;
    }

    public String getObjectClass() {
        return objectClass;
    }

    public void setObjectClass(String objectClass) {
        this.objectClass = objectClass;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        return "EMRSEventInfo{" +
                "eventId='" + eventId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", sendingApp='" + sendingApp + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", patientClass='" + patientClass + '\'' +
                ", visitId='" + visitId + '\'' +
                ", eventObject='" + eventObject + '\'' +
                ", objectClass='" + objectClass + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventKey='" + eventKey + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", operationTime='" + operationTime + '\'' +
                ", eventStatus='" + eventStatus + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", eventTime='" + eventTime + '\'' +
                '}';
    }
}
