package com.johnxb.questionnaire.dao;

import com.johnxb.questionnaire.entity.Questionnaire;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionnaireMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Questionnaire record);

    Questionnaire selectByPrimaryKey(Integer id);

    List<Questionnaire> selectAll();

    int updateByPrimaryKey(Questionnaire record);
    //通过分类id获取问卷数
    int selectCountByClassificationId(@Param("classification_id") int classification_id);
    //通过分类id获取问卷
    List<Questionnaire> seleteByClassificationId(@Param("classification_id") Integer classification_id);
}