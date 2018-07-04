package com.johnxb.questionnaire.dto.Questionnaire;

import com.johnxb.questionnaire.dto.RequestDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class QuestionnaireA04InputDTO extends RequestDTO{
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
