package com.ewell.esb.mq.service.impl;

import com.ewell.esb.bean.ESBEventInfo;
import com.ewell.esb.bean.OperationNameInfo;
import com.ewell.esb.bean.PatVisitInfo;
import com.ewell.esb.bean.StaffInfo;
import com.ewell.esb.common.aop.EventDeal;
import com.ewell.esb.common.util.StringUtils;
import com.ewell.esb.common.util.XmlUtil;
import com.ewell.esb.dao.OperationDao;
import com.ewell.esb.dao.PatVisitDao;
import com.ewell.esb.dao.RoleGrantDao;
import com.ewell.esb.mq.dto.MsgPM02004;
import com.ewell.esb.mq.dto.MsgPS40003;
import com.ewell.esb.mq.dto.MsgPS50005;
import com.ewell.esb.mq.service.HISEventDealService;
import com.ewell.esb.mq.service.PatVisitDealService;
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
public class PatVisitDealServiceImpl implements PatVisitDealService {
    @Resource
    private PatVisitDao pvDao;
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
            int result = 0;
            if (StringUtils.isNotEmpty(patVisit.getBodyHeight())&&(StringUtils.isNotEmpty(patVisit.getBodyWeight()))){
                result = pvDao.updatePatSign(patVisit);
            }else{
                /**
                 * 患者拒测
                 */
                result = 1;
            }
            status = result>0;
        }catch (Exception e1){
            throw e1;
        }
        return status;
    }

}
