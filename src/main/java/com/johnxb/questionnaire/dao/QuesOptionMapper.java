package com.johnxb.questionnaire.dao;

import com.johnxb.questionnaire.entity.QuesOption;
import java.util.List;

public interface QuesOptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuesOption record);

    QuesOption selectByPrimaryKey(Integer id);

    List<QuesOption> selectAll();

    int updateByPrimaryKey(QuesOption record);
}