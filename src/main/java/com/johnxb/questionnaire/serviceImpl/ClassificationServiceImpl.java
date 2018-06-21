package com.johnxb.questionnaire.serviceImpl;

import com.johnxb.questionnaire.dao.ClassificationMapper;
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

    @Autowired
    public ClassificationServiceImpl(ClassificationMapper classificationMapper) {
        this.classificationMapper = classificationMapper;
    }


    //获取所有分类
    public List<Classification> getAllClassification() {
        return this.classificationMapper.selectAll();
    }
}
