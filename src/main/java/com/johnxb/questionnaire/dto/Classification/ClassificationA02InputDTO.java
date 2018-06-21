package com.johnxb.questionnaire.dto.Classification;

import io.swagger.annotations.ApiModelProperty;

public class ClassificationA02InputDTO {
    /**
     * 分类ID
     */
    private Integer classificationId;


    /**
     * 获取 分类ID
     *
     * @return classificationId 分类ID
     */
    @ApiModelProperty(value = "分类ID", name = "classificationId", dataType = "Integer")
    public Integer getClassificationId() {
        return classificationId;
    }

    /**
     * 设置 分类ID
     *
     * @param classificationId 分类ID
     */
    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }
}
