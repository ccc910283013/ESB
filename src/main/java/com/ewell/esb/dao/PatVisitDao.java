package com.ewell.esb.dao;

import com.ewell.esb.bean.PatVisitInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PatVisitDao {
    /**
     *  更新病人体征信息
     * @param info 病人就诊信息
     * @return
     */
    int updatePatSign(PatVisitInfo info);
}
