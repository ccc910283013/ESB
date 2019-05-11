package com.ewell.esb.mq.service.impl;

import com.ewell.esb.bean.ESBEventInfo;
import com.ewell.esb.bean.StaffInfo;
import com.ewell.esb.common.aop.EventDeal;
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
@Slf4j
@Service
@Transactional(rollbackFor=Exception.class)
public class HISEventDealServiceImpl implements HISEventDealService {
    @Autowired
    RoleGrantDao roleDao;
    @Autowired
    PatVisitDao pvDao;
    @Autowired
    OperationDao operDao;
    @Override
    @EventDeal
    public boolean modifyUserGrant(ESBEventInfo info) throws Exception{
        boolean status = false;
        try {
            MsgPM02004 xmlObject = XmlUtil.xmlToJavaBean(MsgPM02004.class,info.getMessage());

            StaffInfo staff = new StaffInfo();
            staff.setHrepCode(xmlObject.getMsgInfo().getMsg().getBody().getRow().getSUBOR_DEPT_CODE());
            staff.setHrepCodeOld(xmlObject.getMsgInfo().getMsg().getBody().getRow().getSUBOR_DEPT_CODE_OLD());
            staff.setEmpName(xmlObject.getMsgInfo().getMsg().getBody().getRow().getSTAFF_NAME());
            staff.setUserName("H"+ xmlObject.getMsgInfo().getMsg().getBody().getRow().getSTAFF_INDEX_NO());
            staff.setJob(xmlObject.getMsgInfo().getMsg().getBody().getRow().getMAJOR_SKILL_POST_NAME());
            if (!((StringUtils.isNotBlank(staff.getUserName())
                    &&StringUtils.isNotBlank(staff.getHrepCode())
                    &&StringUtils.isNotBlank(staff.getHrepCodeOld())))){
                throw new Exception("数据不完整");
            }
            staff.setEmpNo(roleDao.selectEmpNobyUserName(staff.getUserName()));
            if ("护士".equals(staff.getJob())){
                staff.setDeptCode(roleDao.selectWardCodeByDeptCode(roleDao.selectRoleDeptCode(staff.getHrepCode())));
                staff.setDeptCodeOld(roleDao.selectWardCodeByDeptCode(roleDao.selectRoleDeptCode(staff.getHrepCodeOld())));
            }else if("医生".equals(staff.getJob())){
                staff.setDeptCode(roleDao.selectRoleDeptCode(staff.getHrepCode()));
                staff.setDeptCodeOld(roleDao.selectRoleDeptCode(staff.getHrepCodeOld()));
            }else{
                throw new Exception("无需处理");
            }
            staff.setUserId("");
            int roleResult = roleDao.updateRole(staff);
            status = roleResult > 0;
            if (status){
                log.info(staff.getEmpName()+"从"+staff.getDeptCodeOld()+"转入"+staff.getDeptCode()+"成功"+info.getLogNo());
            }else{
                log.info(staff.getEmpName()+"本条数据不需要处理"+info.getLogNo());
            }
        }catch (Exception e){
            throw e;
        }
        return status;
    }

}
