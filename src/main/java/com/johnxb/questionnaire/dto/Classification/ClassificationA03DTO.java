package com.johnxb.questionnaire.dto.Classification;

public class ClassificationA03DTO {
    /**
     * 分类id
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 可见性
     */
    private boolean visible;
    /**
     * 描述
     */
    private String description;
    /**
     * 获取 分类id
     *
     * @return id 分类id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 分类id
     *
     * @param id 分类id
     */
    public void setid(Integer id) {
        this.id = id;
    }

    /**
     * 获取 分类名称
     *
     * @return name 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 可见性
     *
     * @return visible 可见性
     */
    public boolean getVisible() {
        return visible;
    }

    /**
     * 设置 可见性
     *
     * @param visible 可见性
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    /**
     * 获取 描述
     *
     * @return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
