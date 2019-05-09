package com.ewell.esb.dao;

import com.ewell.esb.bean.ESBEventInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface ESBEventInfoDao {
    /**
     *  插入平台消息记录
     * @param info
     * @return
     */
    int insert(ESBEventInfo info);

    /**
     *  更新平台消息状态
     * @param info
     * @return
     */
    int update(ESBEventInfo info);

    /**
     * 查询平台消息
     * @param startTime
     * @param endTime
     * @return
     */
    List<ESBEventInfo> selectByDate(@Param(value = "startTime") String startTime, @Param(value = "endTime")String endTime);

    /**
     *  删除主表消息
     * @param logNo 消息序号
     * @return
     */
    int delete(String logNo);
}
