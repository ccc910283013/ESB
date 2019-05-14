package com.ewell.esb.bean;

public class StaffInfo {
    private String empNo;
    private String empName;
    private String userName;
    private String deptCode;
    private String deptCodeOld;
    private String userId;
    private String job;
    private String hrepCode;
    private String hrepCodeOld;
    private String deptAlias;

    /**
     * 新增字段
     */
    /**
     * 角色ID 4-护士 6-医生
     */
    private String roleId;
    /**
     * 大类ID 2-护士 3-医生
     */
    private String classId;

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
                ", hrepCode='" + hrepCode + '\'' +
                ", hrepCodeOld='" + hrepCodeOld + '\'' +
                ", deptAlias='" + deptAlias + '\'' +
                ", roleId='" + roleId + '\'' +
                ", classId='" + classId + '\'' +
                '}';
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

    public String getDeptCodeOld() {
        return deptCodeOld;
    }

    public void setDeptCodeOld(String deptCodeOld) {
        this.deptCodeOld = deptCodeOld;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHrepCode() {
        return hrepCode;
    }

    public void setHrepCode(String hrepCode) {
        this.hrepCode = hrepCode;
    }

    public String getHrepCodeOld() {
        return hrepCodeOld;
    }

    public void setHrepCodeOld(String hrepCodeOld) {
        this.hrepCodeOld = hrepCodeOld;
    }

    public String getDeptAlias() {
        return deptAlias;
    }

    public void setDeptAlias(String deptAlias) {
        this.deptAlias = deptAlias;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

}
