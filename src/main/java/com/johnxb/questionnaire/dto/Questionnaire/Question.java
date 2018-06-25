package com.johnxb.questionnaire.dto.Questionnaire;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Question {
    @NotNull(message = "问题类型不能为空")
    private Integer type;
    @NotNull(message = "问题描述不能为空")
    private String description;
    @NotNull(message = "选项不能为空")
    private List<Option> options;
    @ApiModelProperty(value = "类型", name = "type", dataType = "Integer")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    @ApiModelProperty(value = "描述", name = "description", dataType = "String")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @ApiModelProperty(value = "选项", name = "options", dataType = "List")
    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
