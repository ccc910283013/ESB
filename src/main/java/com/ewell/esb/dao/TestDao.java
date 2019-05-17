package com.ewell.esb.dao;



import com.ewell.esb.common.aop.MultiSource;
import com.ewell.esb.common.util.DBSourceConstant;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Mapper
@Component
public interface TestDao {
    public String findSum();
    public String findSum1();
    public int test();
}
