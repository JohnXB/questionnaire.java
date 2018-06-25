package com.johnxb.questionnaire.dto.Classification;

import com.johnxb.questionnaire.dto.RequestDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class ClassificationA02InputDTO extends RequestDTO{
    /**
     * 分类ID
     */
    @NotNull(message = "分类id不能为空")
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
