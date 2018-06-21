package com.johnxb.questionnaire.dao;

import com.johnxb.questionnaire.entity.Questionnaire;
import java.util.List;

public interface QuestionnaireMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Questionnaire record);

    Questionnaire selectByPrimaryKey(Integer id);

    List<Questionnaire> selectAll();

    int updateByPrimaryKey(Questionnaire record);
}