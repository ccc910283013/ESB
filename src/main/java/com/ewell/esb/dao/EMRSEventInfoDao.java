package com.ewell.esb.dao;




import com.ewell.esb.bean.EMRSEventInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EMRSEventInfoDao {
    public List<EMRSEventInfo> findAllEvent();
}
