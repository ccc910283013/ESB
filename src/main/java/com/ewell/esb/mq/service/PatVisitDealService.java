package com.ewell.esb.mq.service;

import com.ewell.esb.bean.ESBEventInfo;

public interface PatVisitDealService {
    boolean modifyPatSign(ESBEventInfo info) throws Exception;
}
