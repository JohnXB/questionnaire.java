package com.johnxb.questionnaire.entity;

import java.util.Date;

public class Classification {
    private Integer id;

    private String name;

    private Date createAt;

    private String description;

    private Integer creator;

    private Boolean visible;

    public Classification(Integer id, String name, Date createAt, String description, Integer creator, Boolean visible) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
        this.description = description;
        this.creator = creator;
        this.visible = visible;
    }

    public Classification() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}