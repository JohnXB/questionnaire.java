package com.johnxb.questionnaire.dto.Questionnaire;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class Option {
    @NotNull(message = "描述不能为空")
    private String description;
    @ApiModelProperty(value = "描述", name = "description", dataType = "String")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
