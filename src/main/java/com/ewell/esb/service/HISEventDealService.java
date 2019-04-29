package com.ewell.esb.service;

import com.ewell.esb.bean.StaffInfo;

public interface HISEventDealService {
    boolean modifyUserGrant(StaffInfo staff,String flag);
}
