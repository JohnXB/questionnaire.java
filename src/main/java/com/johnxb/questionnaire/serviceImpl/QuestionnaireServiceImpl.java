package com.johnxb.questionnaire.serviceImpl;

import com.johnxb.questionnaire.dao.QuesOptionMapper;
import com.johnxb.questionnaire.dao.QuestionMapper;
import com.johnxb.questionnaire.dao.QuestionnaireMapper;
import com.johnxb.questionnaire.dao.RecordMapper;
import com.johnxb.questionnaire.entity.QuesOption;
import com.johnxb.questionnaire.entity.Question;
import com.johnxb.questionnaire.entity.Questionnaire;
import com.johnxb.questionnaire.entity.Record;
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
    private final RecordMapper recordMapper;

    @Autowired
    public QuestionnaireServiceImpl(QuestionnaireMapper questionnaireMapper, QuestionMapper questionMapper, QuesOptionMapper optionMapper,RecordMapper recordMapper) {
        this.questionnaireMapper = questionnaireMapper;
        this.questionMapper = questionMapper;
        this.optionMapper = optionMapper;
        this.recordMapper = recordMapper;
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

    public Questionnaire getQuestionnaireById(int id) {
        return this.questionnaireMapper.selectById(id);
    }


    public String checkQuestionnaire(int id, int user_id, boolean visible) {
        if (this.questionnaireMapper.check(id, user_id) <= 0)
            return "该问卷不是您创建，不能改变状态";
        try {
            this.questionnaireMapper.changeByPrimaryKey(id, user_id, visible);
            return "改变状态成功";
        } catch (Exception e) {
            return "改变状态失败";
        }

    }

    public String deleteQuestionnaire(int id, int user_id) {
        if (this.questionnaireMapper.check(id, user_id) <= 0)
            return "该问卷不是您创建，不能删除";
        if (this.questionnaireMapper.deleteByPrimaryKey(id, user_id) > 0) {
            return "删除成功";
        }
        return "删除失败";
    }

    public List<Questionnaire> getUserQuestionnaire(int user_id) {
        return this.questionnaireMapper.seleteByUserId(user_id);
    }

    public boolean fillIn(List<Record> recordList) {
        this.recordMapper.insertList(recordList);
         return true;
    }
}
