package com.ewell.esb.mq.service.impl;

import com.ewell.esb.bean.ESBEventInfo;
import com.ewell.esb.bean.StaffInfo;
import com.ewell.esb.common.aop.EventDeal;
import com.ewell.esb.common.exception.EventFilterException;
import com.ewell.esb.common.util.DealStatusConstant;
import com.ewell.esb.common.util.ProcessLogUtil;
import com.ewell.esb.common.util.StringUtils;
import com.ewell.esb.dao.OperationDao;
import com.ewell.esb.mq.dto.MsgPM02004;
import com.ewell.esb.common.util.XmlUtil;
import com.ewell.esb.dao.PatVisitDao;
import com.ewell.esb.dao.RoleGrantDao;
import com.ewell.esb.mq.dto.MsgPS50005;
import com.ewell.esb.mq.service.HISEventDealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
@Transactional(rollbackFor=Exception.class)
public class HISEventDealServiceImpl implements HISEventDealService {
    @Resource
    private RoleGrantDao roleDao;
    @Resource
    private PatVisitDao pvDao;
    @Resource
    private OperationDao operDao;

    /**
     *  更新角色信息
     * @param info 事件
     * @return 返回更新结果
     * @throws Exception
     */
    @Override
    @EventDeal
    public boolean modifyUserGrant(ESBEventInfo info) throws Exception{
        boolean status = false;
        MsgPM02004 xmlObject = XmlUtil.xmlToJavaBean(MsgPM02004.class,info.getMessage());
        //判断是否为实习生，实习生会存在多个节点
        if (xmlObject.getMsgInfo().getMsg().getBody().size()>1){
            log.info(ProcessLogUtil.getEventLogStr(info,"row节点过多，无需处理",DealStatusConstant.FAILED));
            return false;
        }else if(xmlObject.getMsgInfo().getMsg().getBody().size()==1) {//判断是否存在更新信息
            StaffInfo staff = new StaffInfo();
            staff.setHrepCode(xmlObject.getMsgInfo().getMsg().getBody().get(0).getSUBOR_DEPT_CODE());
            staff.setHrepCodeOld(xmlObject.getMsgInfo().getMsg().getBody().get(0).getSUBOR_DEPT_CODE_OLD());
            staff.setEmpName(xmlObject.getMsgInfo().getMsg().getBody().get(0).getSTAFF_NAME());
            staff.setUserName("H" + xmlObject.getMsgInfo().getMsg().getBody().get(0).getSTAFF_INDEX_NO());
            staff.setJob(xmlObject.getMsgInfo().getMsg().getBody().get(0).getMAJOR_SKILL_POST_NAME());
            if ((StringUtils.isEmpty(staff.getUserName())
                    || (StringUtils.isEmpty(staff.getHrepCode())))) {//判断是否存在待更新科室
                log.info(ProcessLogUtil.getEventLogStr(info,"数据不完整",DealStatusConstant.FAILED));
                return false;
            }
            //设置员工编号
            staff.setEmpNo(roleDao.selectEmpNobyUserName(staff.getUserName()));
            if ("护士".equals(staff.getJob())) {
                String deptCode = roleDao.selectRoleDeptCode(staff.getHrepCode());
                String deptCodeOld = roleDao.selectRoleDeptCode(staff.getHrepCodeOld());
                String wardCode = roleDao.selectWardCodeByDeptCode(deptCode);
                String wardCodeOld = roleDao.selectWardCodeByDeptCode(deptCodeOld);
                staff.setDeptCode(wardCode == null? deptCode:wardCode);
                staff.setDeptCodeOld(wardCodeOld == null?deptCodeOld:wardCodeOld);
            } else if ("医生".equals(staff.getJob())) {
                staff.setDeptCode(roleDao.selectRoleDeptCode(staff.getHrepCode()));
                staff.setDeptCodeOld(roleDao.selectRoleDeptCode(staff.getHrepCodeOld()));
            } else {
                log.info(ProcessLogUtil.getEventLogStr(info,"无需处理",DealStatusConstant.FAILED));
                return false;
            }
            staff.setUserId("");
            int roleResult = 0;
            //如果不存在旧科室,则判断为插入
            if (StringUtils.isBlank(staff.getDeptCodeOld())) {
                switch (staff.getJob()) {
                    case "医生":
                        staff.setRoleId("6");
                        staff.setClassId("3");
                        break;
                    case "护士":
                        staff.setRoleId("4");
                        staff.setClassId("2");
                        break;
                }
                roleResult = roleDao.insertRole(staff);
            } else {
                roleResult = roleDao.updateRole(staff);
            }
            status = roleResult > 0;
            if (status) {
                log.info(ProcessLogUtil.getEventLogStr(info,
                        staff.getEmpName() + "从" + staff.getDeptCodeOld() + "转入" + staff.getDeptCode() + "成功" + info.getLogNo(),
                        DealStatusConstant.SUCCESS));
            } else {
                log.info(ProcessLogUtil.getEventLogStr(info,
                        staff.getEmpName() + "本条数据不需要处理" + info.getLogNo(),
                        DealStatusConstant.SUCCESS));
            }
        }
        return status;
    }

}
