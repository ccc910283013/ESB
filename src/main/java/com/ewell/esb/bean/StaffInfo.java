package com.ewell.esb.bean;

public class StaffInfo {
    private String empNo;
    private String empName;
    private String userName;
    private String deptCode;
    private String deptCodeOld;
    private String userId;
    private String job;

    @Override
    public String toString() {
        return "StaffInfo{" +
                "empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
                ", userName='" + userName + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", deptCodeOld='" + deptCodeOld + '\'' +
                ", userId='" + userId + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public String getDeptCodeOld() {
        return deptCodeOld;
    }

    public void setDeptCodeOld(String deptCodeOld) {
        this.deptCodeOld = deptCodeOld;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
}
