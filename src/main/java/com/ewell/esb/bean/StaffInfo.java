package com.ewell.esb.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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


}
