package com.johnxb.questionnaire.entity;

import java.util.Date;

public class QuesOption {
    private Integer id;

    private String description;

    private Date createAt;

    private Date updateAt;

    private Integer questionId;

    public QuesOption(Integer id, String description, Date createAt, Date updateAt, Integer questionId) {
        this.id = id;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.questionId = questionId;
    }

    public QuesOption() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}