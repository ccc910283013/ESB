package com.ewell.esb.service.impl;

import com.ewell.esb.bean.StaffInfo;
import com.ewell.esb.dao.RoleGrantDao;
import com.ewell.esb.service.HISEventDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HISEventDealServiceImpl implements HISEventDealService {
    @Autowired
    RoleGrantDao roleDao;
    @Override
    @Transactional(rollbackFor=Exception.class)
    public boolean modifyUserGrant(StaffInfo staff,String flag) {
        boolean status = false;
        try {
            if ("update".equals(flag)){
                int roleResult = roleDao.updateRole(staff);
                int selectResult = roleDao.selectByEmpId(staff);
                status = roleResult>0?true:false;
                if (selectResult == 0){
                    int groupResult = roleDao.updateStaffGroup(staff);
                }
            }else if("insert".equals(flag)){
                status = true;
            }
        }catch (Exception e){

            throw e;
        }
        return status;
    }
}
