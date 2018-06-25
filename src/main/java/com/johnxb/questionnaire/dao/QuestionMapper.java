package com.johnxb.questionnaire.dao;

import com.johnxb.questionnaire.entity.Question;
import com.johnxb.questionnaire.entity.Questionnaire;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    Question selectByPrimaryKey(Integer id);

    List<Question> selectAll();

    int updateByPrimaryKey(Question record);
    int insertByParent(Question question);
}