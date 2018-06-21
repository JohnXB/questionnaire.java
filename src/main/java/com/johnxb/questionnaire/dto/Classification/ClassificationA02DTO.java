package com.johnxb.questionnaire.dto.Classification;

public class ClassificationA02DTO {
    /**
     * 分类id
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 问卷数
     */
    private Integer count;

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

    /**
     * 获取 问卷数
     *
     * @return count 问卷数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置 问卷数
     *
     * @param count 问卷数
     */
    public void setCount(Integer count) {
        this.count = count;
    }

}
