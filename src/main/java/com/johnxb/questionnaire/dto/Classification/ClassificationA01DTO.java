package com.johnxb.questionnaire.dto.Classification;

public class ClassificationA01DTO {
    /**
     * 分类id
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String name;

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
}
