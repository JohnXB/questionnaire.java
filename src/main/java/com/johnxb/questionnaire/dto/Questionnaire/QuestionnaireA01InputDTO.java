package com.johnxb.questionnaire.dto.Questionnaire;

import io.swagger.annotations.ApiModelProperty;

public class QuestionnaireA01InputDTO {
    private Integer id;
    @ApiModelProperty(value = "分类id", name = "id", dataType = "Ingteger")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
