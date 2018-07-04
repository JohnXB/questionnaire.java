package com.johnxb.questionnaire.service;

import com.johnxb.questionnaire.entity.Questionnaire;
import com.johnxb.questionnaire.entity.Record;

import java.util.List;

public interface QuestionnaireService {
   List<Questionnaire> getByParentId(Integer classification_id);
   boolean createQuestionnaire(Questionnaire questionnaire,int user_id);
   Questionnaire getQuestionnaireById(int id);
   String checkQuestionnaire(int id,int user_id,boolean visible);
   String deleteQuestionnaire(int id,int user_id);
   List<Questionnaire> getUserQuestionnaire(int user_id);
   boolean fillIn(List<Record> recordList);
}
