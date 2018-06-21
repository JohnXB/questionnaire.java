package com.johnxb.questionnaire.entity;

import java.util.Date;

public class Question {
    private Integer id;

    private Integer type;

    private String description;

    private Integer questionnaireId;

    private Date createAt;

    private Date updateAt;

    public Question(Integer id, Integer type, String description, Integer questionnaireId, Date createAt, Date updateAt) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.questionnaireId = questionnaireId;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Question() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}