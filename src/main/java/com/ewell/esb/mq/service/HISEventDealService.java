package com.ewell.esb.mq.service;

import com.ewell.esb.bean.ESBEventInfo;

public interface HISEventDealService {
    boolean modifyUserGrant(ESBEventInfo info) throws Exception;
}
