package com.johnxb.questionnaire.dto.Classification;

import com.johnxb.questionnaire.dto.RequestDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ClassificationA05InputDTO extends RequestDTO {

    @NotNull(message = "分类名称不能为空")
    private String name;

    @NotNull(message = "分类描述不能为空")
    private String description;

    private Boolean visible;
    @ApiModelProperty(value = "分类名称", name = "name", dataType = "String")
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
    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
