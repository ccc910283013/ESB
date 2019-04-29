package com.ewell.esb.common.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AccessControl")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessControl {
    private String UserName;
    private String Password;
    private String Fid;

    @Override
    public String toString() {
        return "AccessControl{" +
                "UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                ", Fid='" + Fid + '\'' +
                '}';
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFid() {
        return Fid;
    }

    public void setFid(String fid) {
        Fid = fid;
    }
}
