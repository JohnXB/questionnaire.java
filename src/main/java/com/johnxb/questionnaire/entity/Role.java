package com.johnxb.questionnaire.entity;

public class Role {
    private Integer id;

    private String roleName;

    private String roleCode;

    public Role(Integer id, String roleName, String roleCode) {
        this.id = id;
        this.roleName = roleName;
        this.roleCode = roleCode;
    }

    public Role() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }
}