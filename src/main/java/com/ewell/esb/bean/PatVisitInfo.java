package com.ewell.esb.bean;

public class PatVisitInfo {
    private String patId;
    private String visitId;
    private String bodyWeight;
    private String bodyHeight;

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

    public String getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(String bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public String getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(String bodyHeight) {
        this.bodyHeight = bodyHeight;
    }

    @Override
    public String toString() {
        return "PatVisitInfo{" +
                "patId='" + patId + '\'' +
                ", visitId='" + visitId + '\'' +
                ", bodyWeight='" + bodyWeight + '\'' +
                ", bodyHeight='" + bodyHeight + '\'' +
                '}';
    }
}
