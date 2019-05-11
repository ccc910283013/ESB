package com.ewell.esb.mq.service;

import com.ewell.esb.bean.ESBEventInfo;

public interface OperationDealService {
    boolean modifyOperationName(ESBEventInfo info) throws Exception;
}
