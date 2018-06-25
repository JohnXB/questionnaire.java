package com.johnxb.questionnaire.entity;

import java.util.Date;
import java.util.List;

public class Questionnaire {
    private Integer id;

    private String title;

    private Date createAt;

    private Integer status;

    private String description;

    private Integer classificationId;

    private Integer creatorId;
    private String creatorName;
    private Boolean visible;

    private Date updateAt;

    private Boolean template;
    private List<Question> questions;

    public Questionnaire(Integer id, String title, Date createAt, Integer status, String description, Integer classificationId, Integer creatorId, Boolean visible, Date updateAt, Boolean template) {
        this.id = id;
        this.title = title;
        this.createAt = createAt;
        this.status = status;
        this.description = description;
        this.classificationId = classificationId;
        this.creatorId = creatorId;
        this.visible = visible;
        this.updateAt = updateAt;
        this.template = template;
    }

    public Questionnaire() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Boolean getTemplate() {
        return template;
    }

    public void setTemplate(Boolean template) {
        this.template = template;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}