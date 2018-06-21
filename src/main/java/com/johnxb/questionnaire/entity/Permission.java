package com.johnxb.questionnaire.entity;

import java.util.Date;

public class Permission {
    private Integer id;

    private String permissionName;

    private String permissionCode;

    private Date createAt;

    public Permission(Integer id, String permissionName, String permissionCode, Date createAt) {
        this.id = id;
        this.permissionName = permissionName;
        this.permissionCode = permissionCode;
        this.createAt = createAt;
    }

    public Permission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}