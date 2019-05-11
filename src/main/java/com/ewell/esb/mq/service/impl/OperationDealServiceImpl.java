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
import com.ewell.esb.mq.service.OperationDealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(rollbackFor=Exception.class)
public class OperationDealServiceImpl implements OperationDealService {
    @Autowired
    OperationDao operDao;
    @Override
    @EventDeal
    public boolean modifyOperationName(ESBEventInfo info) throws Exception {
        boolean status = false;
        try{
            MsgPS50005 xmlObject = XmlUtil.xmlToJavaBean(MsgPS50005.class,info.getMessage());
            OperationNameInfo operName = new OperationNameInfo();
            if (StringUtils.isNotBlank(xmlObject.getMsgInfo().getMsg().getPATIENT_ID())&&
                    StringUtils.isNotBlank(xmlObject.getMsgInfo().getMsg().getPATIENT_ID())&&
                    StringUtils.isNotBlank(xmlObject.getMsgInfo().getMsg().getOPER_ID())&&
                    StringUtils.isNotBlank(xmlObject.getMsgInfo().getMsg().getOPERATION_NO())){
                int result = operDao.updateOperationName(operName);
                status = result>0?true:false;
            }else{
                throw new Exception("值不正确");
            }
        }catch (Exception e){
            throw e;
        }
        return status;
    }
}
