package com.ewell.esb.dao;



import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface TestDao {
    public String findSum();
}
