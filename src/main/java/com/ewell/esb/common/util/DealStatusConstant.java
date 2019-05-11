package com.ewell.esb.common.util;

public enum DealStatusConstant {
    SUCCESS("0","成功"),
    FAILED("2","失败");
    private String status;
    private String text;
    private DealStatusConstant(String status,String text){
        this.status = status;
        this.text = text;
    };
    public String getStatus() {
        return status;
    }

    public String getText() {
        return text;
    }
}
