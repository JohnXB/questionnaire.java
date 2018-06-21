package com.johnxb.questionnaire.serviceImpl;

import com.johnxb.questionnaire.dao.ClassificationMapper;
import com.johnxb.questionnaire.dao.QuestionnaireMapper;
import com.johnxb.questionnaire.entity.Classification;
import com.johnxb.questionnaire.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationMapper classificationMapper;
    private final QuestionnaireMapper questionnaireMapper;

    @Autowired
    public ClassificationServiceImpl(ClassificationMapper classificationMapper, QuestionnaireMapper questionnaireMapper) {
        this.classificationMapper = classificationMapper;
        this.questionnaireMapper = questionnaireMapper;
    }


    //获取所有分类
    public List<Classification> getAllClassification() {
        return this.classificationMapper.selectAllVisible();
    }

    //通过id获取分类信息
    public Classification getClassificationById(int classification_id) {
        return this.classificationMapper.selectByPrimaryKey(classification_id);
    }

    //获取所有分类（管理员
    public List<Classification> getAllClassificationByAdmin() {
        return this.classificationMapper.selectAll();
    }

    //获取分类 问卷数
    public int selectCountByClassificationId(int classification_id) {
        return this.questionnaireMapper.selectCountByClassificationId(classification_id);
    }

}
