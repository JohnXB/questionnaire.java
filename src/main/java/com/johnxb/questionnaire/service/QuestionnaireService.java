package com.johnxb.questionnaire.service;

import com.johnxb.questionnaire.entity.Questionnaire;

import java.util.List;

public interface QuestionnaireService {
   List<Questionnaire> getByParentId(Integer classification_id);
   boolean createQuestionnaire(Questionnaire questionnaire,int user_id);
}
