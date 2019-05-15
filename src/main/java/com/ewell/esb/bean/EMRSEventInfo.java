package com.ewell.esb.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
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

}
