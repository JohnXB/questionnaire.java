package com.johnxb.questionnaire.dto.Questionnaire;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import javax.validation.constraints.NotNull;

public class QuestionnaireIdInputDTO {
    @NotNull(message = "问卷id不可为空")
    private Integer id;
@ApiModelProperty(value = "问卷id", name = "id", dataType = "Integer")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
