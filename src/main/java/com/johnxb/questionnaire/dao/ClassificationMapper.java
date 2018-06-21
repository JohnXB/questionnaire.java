package com.johnxb.questionnaire.dao;

import com.johnxb.questionnaire.entity.Classification;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ClassificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classification record);

    Classification selectByPrimaryKey(Integer id);

    List<Classification> selectAll();

    List<Classification> selectAllVisible();

    int updateStatus(Classification classification);
}