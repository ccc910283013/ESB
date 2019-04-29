package com.ewell.esb.common.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MessageHeader")
public class MessageHeader {
    private String Fid;
    private String SourceSysCode;
    private String TargetSysCode;
    private String MsgDate;

    public String getFid() {
        return Fid;
    }

    public void setFid(String fid) {
        Fid = Fid;
    }

    public String getSourceSysCode() {
        return SourceSysCode;
    }

    public void setSourceSysCode(String sourceSysCode) {
        SourceSysCode = sourceSysCode;
    }

    public String getTargetSysCode() {
        return TargetSysCode;
    }

    public void setTargetSysCode(String targetSysCode) {
        TargetSysCode = targetSysCode;
    }

    public String getMsgDate() {
        return MsgDate;
    }

    public void setMsgDate(String msgDate) {
        MsgDate = msgDate;
    }
}
