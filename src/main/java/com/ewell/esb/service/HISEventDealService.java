package com.ewell.esb.service;

import com.ewell.esb.bean.ESBEventInfo;

public interface HISEventDealService {
    boolean modifyUserGrant(ESBEventInfo info) throws Exception;

    boolean modifyPatSign(ESBEventInfo info) throws Exception;
}
