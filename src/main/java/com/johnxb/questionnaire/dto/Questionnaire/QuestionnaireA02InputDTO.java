package com.johnxb.questionnaire.dto.Questionnaire;

import com.johnxb.questionnaire.dto.RequestDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class QuestionnaireA02InputDTO extends RequestDTO {
    @NotNull(message = "问卷标题不能为空")
    private String title;
    @NotNull(message = "问卷描述不能为空")
    private String description;

    private Integer classificationId;
    @NotNull(message = "问题不能为空")
    private List<Question> questions;
    @ApiModelProperty(value = "标题", name = "title", dataType = "String")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @ApiModelProperty(value = "描述", name = "description", dataType = "String")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @ApiModelProperty(value = "分类ID", name = "classificationId", dataType = "Integer")
    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }
    @ApiModelProperty(value = "问题", name = "questions", dataType = "List")
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
