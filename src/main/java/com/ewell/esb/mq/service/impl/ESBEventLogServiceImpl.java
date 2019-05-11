package com.ewell.esb.mq.service.impl;

import com.ewell.esb.bean.ESBEventInfo;
import com.ewell.esb.common.aop.EventDeal;
import com.ewell.esb.common.util.DealStatusConstant;
import com.ewell.esb.dao.ESBEventInfoDao;
import com.ewell.esb.dao.ESBEventLogDao;
import com.ewell.esb.mq.service.ESBEventLogService;
import com.ewell.esb.mq.service.HISEventDealService;
import com.ewell.esb.mq.service.OperationDealService;
import com.ewell.esb.mq.service.PatVisitDealService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Service
public class ESBEventLogServiceImpl implements ESBEventLogService {
    @Autowired
    ESBEventInfoDao dao;
    @Autowired
    ESBEventLogDao logDao;
    @Autowired
    HISEventDealService hisService;
    @Autowired
    OperationDealService operService;
    @Autowired
    PatVisitDealService pvService;

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public boolean esbEventTransDeal(JoinPoint joinPoint,DealStatusConstant con) {
        boolean eventDealStatus = false;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //参数值
        Object[] argValues = joinPoint.getArgs();
        //参数名称
        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        if (argValues.length > 0) {
            ESBEventInfo e = (ESBEventInfo) argValues[0];
            e.setLogStatus(con.getStatus());
            if ("0".equals(con.getStatus())){
                logDao.insert(e.getLogNo());
                int i = dao.delete(e.getLogNo());
                eventDealStatus = i>0;
            }else if ("2".equals(con.getStatus())){
                int i = dao.update(e);
                eventDealStatus = i>0;
            }
        }
        return eventDealStatus;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean esbEventInsert(ESBEventInfo info) {
        int row = dao.insert(info);
        return row>0;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public boolean esbEventDeal(String currentTime){
        boolean status = false;
        List<ESBEventInfo> infoList = dao.selectByDate(currentTime);
        if (infoList.size() > 0){
            int result = dao.updateProcessed(currentTime);
            System.out.println(infoList.size());
            for (int i = 0; i < infoList.size(); i++) {
                ESBEventInfo info = infoList.get(i);
                String serviceId = info.getServiceId();
                try {
                    if ("PM02004".equals(serviceId)) {
                        status = hisService.modifyUserGrant(info);
                    }
                    if ("PS40003".equals(serviceId)) {
                        status = pvService.modifyPatSign(info);
                    }
                    //test
                    if ("PS50005".equals(serviceId)) {
                        status = operService.modifyOperationName(info);
                    }
                } catch (Exception e) {
                    log.error("服务" + serviceId + "执行异常,logNo=" + info.getLogNo() + "------->" + e.getMessage());
                }
            }
        }
        return status;
    }
}
