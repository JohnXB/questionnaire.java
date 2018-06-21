package com.johnxb.questionnaire.service;

import com.johnxb.questionnaire.entity.Classification;

import java.util.List;

public interface ClassificationService {
    //获取所有可见分类
    List<Classification> getAllClassification();

    //通过id获取分类信息
    Classification getClassificationById(int classification_id);

    //获取所有分类(管理员）
    List<Classification> getAllClassificationByAdmin();

    //获取分类 问卷数
    int selectCountByClassificationId(int classification_id);

    //修改分类信息
    boolean changeStatus(Classification classification);
}
