package com.ewell.esb.dao;

import com.ewell.esb.bean.StaffInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
@Mapper
@Component
public interface RoleGrantDao {
    /**
     *  查询是否存在医疗组信息
     * @param staff  员工信息
     * @return
     */
    int selectByEmpId(StaffInfo staff);
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
    //int insertRole(StaffInfo staff);

    /**
     * 更新医疗组信息
     * @param staff 员工信息
     * @return
     */
    int updateStaffGroup(StaffInfo staff);

    /**
     * 插入医疗组信息
     * @param staff 员工信息
     * @return
     */
    int insertStaffGroup(StaffInfo staff);
}
