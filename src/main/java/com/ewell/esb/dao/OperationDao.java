package com.ewell.esb.dao;

import com.ewell.esb.bean.OperationNameInfo;
import com.ewell.esb.bean.PatVisitInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OperationDao {
    /**
     * 更新手术名称、切口等级、手术等级
     * @param info
     * @return
     */
    int updateOperationName(OperationNameInfo info);

}
