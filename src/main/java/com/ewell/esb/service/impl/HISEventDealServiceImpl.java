package com.ewell.esb.service.impl;

import com.ewell.esb.bean.ESBEventInfo;
import com.ewell.esb.bean.PatVisitInfo;
import com.ewell.esb.bean.StaffInfo;
import com.ewell.esb.common.aop.EventDeal;
import com.ewell.esb.common.dto.MsgPM02004;
import com.ewell.esb.common.dto.MsgPS40003;
import com.ewell.esb.common.util.XmlUtil;
import com.ewell.esb.dao.PatVisitDao;
import com.ewell.esb.dao.RoleGrantDao;
import com.ewell.esb.service.HISEventDealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service
@Transactional(rollbackFor=Exception.class,isolation = Isolation.READ_COMMITTED,propagation = Propagation.SUPPORTS)
public class HISEventDealServiceImpl implements HISEventDealService {
    @Autowired
    RoleGrantDao roleDao;
    @Autowired
    PatVisitDao pvDao;
    @Override
    @EventDeal
    public boolean modifyUserGrant(ESBEventInfo info) throws Exception{
        boolean status = false;
        try {
            MsgPM02004 xmlObject = XmlUtil.xmlToJavaBean(MsgPM02004.class,info.getMessage());
            StaffInfo staff = new StaffInfo();
            staff.setDeptCode(xmlObject.getMsgInfo().getMsg().getBody().getRow().getSUBOR_DEPT_CODE());
            staff.setDeptCodeOld(xmlObject.getMsgInfo().getMsg().getBody().getRow().getSUBOR_DEPT_CODE_OLD());
            staff.setEmpName(xmlObject.getMsgInfo().getMsg().getBody().getRow().getSTAFF_NAME());
            staff.setEmpNo(xmlObject.getMsgInfo().getMsg().getBody().getRow().getSTAFF_INDEX_NO());
            staff.setJob(xmlObject.getMsgInfo().getMsg().getBody().getRow().getSTAFF_CATEG_NAME());
            staff.setUserId("");
            int roleResult = roleDao.updateRole(staff);
            int selectResult = roleDao.selectByEmpId(staff);
            status = roleResult>0?true:false;
            if (status == true){
                log.info(staff.getEmpName()+"从"+staff.getDeptCodeOld()+"转入"+staff.getDeptCode()+"成功"+info.getLogNo());
            }else{
                log.info(staff.getEmpName()+"本条数据不需要处理"+info.getLogNo());
            }
            if (selectResult == 0){
                int groupResult = roleDao.updateStaffGroup(staff);
            }
        }catch (Exception e){
            throw e;
        }
        return status;
    }

    @Override
    @EventDeal
    public boolean modifyPatSign(ESBEventInfo info) throws Exception {
        boolean status = false;
        try{
            MsgPS40003 xmlObject = XmlUtil.xmlToJavaBean(MsgPS40003.class,info.getMessage());
            PatVisitInfo patVisit = new PatVisitInfo();
            patVisit.setPatId(xmlObject.getMsgInfo().getMsg().getPAT_NO());
            patVisit.setVisitId(xmlObject.getMsgInfo().getMsg().getINHOSP_NUM());
            patVisit.setBodyHeight(xmlObject.getMsgInfo().getMsg().getHEIGHT());
            patVisit.setBodyWeight(xmlObject.getMsgInfo().getMsg().getWEIGHT());
            int result = pvDao.updatePatSign(patVisit);
            status = result>0?true:false;
        }catch (Exception e){
            throw e;
        }
        return status;
    }
}
