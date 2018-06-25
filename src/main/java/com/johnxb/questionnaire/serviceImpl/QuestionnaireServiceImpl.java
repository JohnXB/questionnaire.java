package com.johnxb.questionnaire.serviceImpl;

import com.johnxb.questionnaire.dao.QuesOptionMapper;
import com.johnxb.questionnaire.dao.QuestionMapper;
import com.johnxb.questionnaire.dao.QuestionnaireMapper;
import com.johnxb.questionnaire.entity.QuesOption;
import com.johnxb.questionnaire.entity.Question;
import com.johnxb.questionnaire.entity.Questionnaire;
import com.johnxb.questionnaire.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private final QuestionnaireMapper questionnaireMapper;
    private final QuestionMapper questionMapper;
    private final QuesOptionMapper optionMapper;

    @Autowired
    public QuestionnaireServiceImpl(QuestionnaireMapper questionnaireMapper, QuestionMapper questionMapper, QuesOptionMapper optionMapper) {
        this.questionnaireMapper = questionnaireMapper;
        this.questionMapper = questionMapper;
        this.optionMapper = optionMapper;
    }

    @Override
    public List<Questionnaire> getByParentId(Integer classification_id) {
        return this.questionnaireMapper.seleteByClassificationId(classification_id);
    }

    @Override
    public boolean createQuestionnaire(Questionnaire questionnaire, int user_id) {
        try {
            questionnaire.setCreatorId(user_id);
            questionnaire.setTemplate(false);
            this.questionnaireMapper.insert(questionnaire);
            List<Question> questionList = questionnaire.getQuestions();

            for (Question question : questionList) {
                //插入问题
                question.setQuestionnaireId(questionnaire.getId());
                this.questionMapper.insertByParent(question);
                //插入选项
                List<QuesOption> optionList = question.getOptions();
                for (QuesOption option : optionList) {
                    option.setQuestionId(question.getId());
                    this.optionMapper.insertByParent(option);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
