package com.ewell.esb.mq.service;

import com.ewell.esb.common.aop.MultiSource;
import com.ewell.esb.common.util.DBSourceConstant;
import com.ewell.esb.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {
    @Autowired
    private TestDao dao;
    @MultiSource(name = DBSourceConstant.DATA_SOURCE_CLUSTER)
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void test01(){
        System.out.println(dao.test());
        System.out.println(1/0);
    }
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void test02(){
        System.out.println(dao.test());
        System.out.println(1/0);
    }
}
