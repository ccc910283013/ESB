package com.ewell.esb.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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


}
