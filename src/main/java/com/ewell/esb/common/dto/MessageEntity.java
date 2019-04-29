package com.ewell.esb.common.dto;

public class MessageEntity {
    /** 消失代码  */
    private  Boolean code;
    /** 消息内容*/
    private  String message;

    public Boolean getCode() {
        return code;
    }

    public void setCode(Boolean code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
