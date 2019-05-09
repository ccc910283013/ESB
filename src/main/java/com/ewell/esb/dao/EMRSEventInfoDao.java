package com.ewell.esb.dao;




import com.ewell.esb.bean.EMRSEventInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface EMRSEventInfoDao {
    public List<EMRSEventInfo> findAllEvent();
}
