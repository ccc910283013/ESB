package com.ewell.esb.dao;



import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TestDao {
    public String findSum();
}
