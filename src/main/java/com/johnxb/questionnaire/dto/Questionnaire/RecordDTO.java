package com.johnxb.questionnaire.dto.Questionnaire;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class RecordDTO {
    @NotNull(message = "问卷id不能为空")
    private Integer questionnaire_id;
    @NotNull(message = "问题id不能为空")
    private Integer question_id;

    @NotNull(message = "选项不能为空")
    private List<Integer> options;
    @ApiModelProperty(value = "问卷id", name = "questionnaire_id", dataType = "Integer")
    public Integer getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(Integer questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }
    @ApiModelProperty(value = "问题id", name = "question_id", dataType = "Integer")
    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }
    @ApiModelProperty(value = "选项", name = "options", dataType = "List")
    public List<Integer> getOptions() {
        return options;
    }

    public void setOptions(List<Integer> options) {
        this.options = options;
    }
}
