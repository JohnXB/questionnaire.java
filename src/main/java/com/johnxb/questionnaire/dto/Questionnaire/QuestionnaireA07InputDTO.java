package com.johnxb.questionnaire.dto.Questionnaire;

import com.johnxb.questionnaire.dto.RequestDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class QuestionnaireA07InputDTO extends RequestDTO{
    @NotNull(message = "填写记录不能为空")
    private List<RecordDTO> record;
    @ApiModelProperty(value = "选项", name = "record", dataType = "List")
    public List<RecordDTO> getRecord() {
        return record;
    }

    public void setRecord(List<RecordDTO> record) {
        this.record = record;
    }
}
