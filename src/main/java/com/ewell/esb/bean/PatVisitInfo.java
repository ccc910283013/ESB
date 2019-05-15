package com.ewell.esb.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PatVisitInfo {
    private String patId;
    private String visitId;
    private String bodyWeight;
    private String bodyHeight;

}
