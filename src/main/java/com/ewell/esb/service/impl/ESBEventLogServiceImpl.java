package com.ewell.esb.service.impl;

import com.ewell.esb.bean.ESBEventInfo;
import com.ewell.esb.common.util.DateUtil;
import com.ewell.esb.dao.ESBEventInfoDao;
import com.ewell.esb.dao.ESBEventLogDao;
import com.ewell.esb.service.ESBEventLogService;
import com.ewell.esb.service.HISEventDealService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    @Override
    public boolean esbEventTransDeal(JoinPoint joinPoint,String status) {
        boolean eventDealStatus = false;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //参数值
        Object[] argValues = joinPoint.getArgs();
        //参数名称
        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        if (argValues.length > 0) {
            ESBEventInfo e = (ESBEventInfo) argValues[0];
            e.setLogStatus(status);
            if ("0".equals(status)){
                logDao.insert(e.getLogNo());
                int i = dao.delete(e.getLogNo());
                eventDealStatus = i>0?true:false;
            }else if ("2".equals(status)){
                int i = dao.update(e);
                eventDealStatus = i>0?true:false;
            }
        }
        return eventDealStatus;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean esbEventInsert(ESBEventInfo info) {
        int row = dao.insert(info);
        return row>0?true:false;
    }

    @Override
    public boolean esbEventDeal(String startTime,String endTime){
        boolean status = false;
        List<ESBEventInfo> infoList = dao.selectByDate(startTime,endTime);
        System.out.println(infoList.size());
        for(int i=0;i<infoList.size();i++){
            ESBEventInfo info = infoList.get(i);
            String serviceId = info.getServiceId();
            try{
                if ("PM02004".equals(serviceId)){
                    status = hisService.modifyUserGrant(info);
                }
                if ("PS40003".equals(serviceId)){
                    status = hisService.modifyPatSign(info);
                }
            }catch (Exception e){
                log.error("服务"+serviceId+"执行异常,logNo="+info.getLogNo()+"------->"+e.getMessage());
            }
        }
        System.out.println(status);
        return status;
    }
}
