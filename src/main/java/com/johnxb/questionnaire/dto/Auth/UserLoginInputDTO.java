package com.johnxb.questionnaire.dto.Auth;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class UserLoginInputDTO {
    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    private String username;

    /**
     * 用户名
     */
    @NotNull(message = "密码不能为空")
    private String password;

    /**
     * 获取 用户名
     *
     * @return userName 用户名
     */
    @ApiModelProperty(value = "用户名", name = "username", dataType = "String")
    public String getUsername() {
        return username;
    }

    /**
     * 设置 用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @ApiModelProperty(value = "密码", name = "password", dataType = "String")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
