package com.ewell.esb.dao;

import com.ewell.esb.bean.ESBEventInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ESBEventLogDao {
    /**
     *  插入平台消息记录
     * @param logNo
     * @return
     */
    int insert(String logNo);

}
