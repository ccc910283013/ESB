package com.ewell.esb.dao;

import com.ewell.esb.bean.StaffInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoleGrantDao {
    /**
     * 获取员工编号
     * @param empNo
     * @return
     */
    String selectEmpNobyUserName(String empNo);
    /**
     * 获取病区代码
     * @param deptCode
     * @return
     */
    String selectWardCodeByDeptCode(String  deptCode);
    /**
     * 根据机构代码查询科室代码
     * @param herpCode
     * @return
     */
    String selectRoleDeptCode(String herpCode);
    /**
     * 更新角色信息
     * @param staff  员工信息
     * @return
     */
    int updateRole(StaffInfo staff);
    /**
     * 插入角色信息
     * @param staff  员工信息
     * @return
     */

}
