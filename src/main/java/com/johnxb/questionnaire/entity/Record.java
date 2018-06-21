package com.johnxb.questionnaire.entity;

import java.util.Date;

public class Record {
    private Integer id;

    private Integer questionnaireId;

    private Integer questionId;

    private Integer optionId;

    private Integer userId;

    private Date createAt;

    private String ip;

    public Record(Integer id, Integer questionnaireId, Integer questionId, Integer optionId, Integer userId, Date createAt, String ip) {
        this.id = id;
        this.questionnaireId = questionnaireId;
        this.questionId = questionId;
        this.optionId = optionId;
        this.userId = userId;
        this.createAt = createAt;
        this.ip = ip;
    }

    public Record() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}