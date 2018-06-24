package com.johnxb.questionnaire.dto.Auth;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class UserSignUpInputDTO {
    @NotNull(message = "昵称不能为空")
    private String name;
    @NotNull(message = "登录名不能为空")
    private String username;
    @NotNull(message = "邮箱不能为空")
    private String mail;
    @NotNull(message = "密码不能为空")
    private String password;
    @NotNull(message = "性别不能为空")
    private String gender;
    @NotNull(message = "电话不能为空")
    private String phone;

    @ApiModelProperty(value = "昵称", name = "name", dataType = "String")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(value = "登录名", name = "username", dataType = "String")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ApiModelProperty(value = "邮箱", name = "mail", dataType = "String")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @ApiModelProperty(value = "密码", name = "password", dataType = "String")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ApiModelProperty(value = "性别", name = "gender", dataType = "String")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @ApiModelProperty(value = "电话", name = "phone", dataType = "String")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
