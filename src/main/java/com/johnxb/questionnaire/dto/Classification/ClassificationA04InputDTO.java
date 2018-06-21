package com.johnxb.questionnaire.dto.Classification;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class ClassificationA04InputDTO {
    /**
     * 分类ID
     */
    @NotNull(message = "分类id不能为空")
    private Integer id;
    @NotNull(message = "分类名称不能为空")
    private String name;


    @NotNull(message = "分类描述不能为空")
    private String description;
    private boolean visible;

    /**
     * 获取 分类ID
     *
     * @return classificationId 分类ID
     */
    @ApiModelProperty(value = "分类ID", name = "id", dataType = "Integer")
    public Integer getId() {
        return id;
    }

    /**
     * 设置 分类ID
     *
     * @param id 分类ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    @ApiModelProperty(value = "分类名称", name = "classificationName", dataType = "String")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(value = "分类描述", name = "description", dataType = "String")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ApiModelProperty(value = "分类可见性", name = "visible", dataType = "boolean")
    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
