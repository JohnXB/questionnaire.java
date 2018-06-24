package com.johnxb.questionnaire.entity;

import java.util.Date;
import java.util.List;

public class AuthUser {
    private Integer id;

    private String name;
    private String username;
    private String mail;

    private String password;

    private String avatar;

    private Date registerAt;

    private String gender;

    private String phone;

    private String currentToken;

    private List<String> roles;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public AuthUser(Integer id, String name, String mail, String password, String avatar, Date registerAt, String gender, String phone, String currentToken) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.avatar = avatar;
        this.registerAt = registerAt;
        this.gender = gender;
        this.phone = phone;
        this.currentToken = currentToken;
    }

    public AuthUser() {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Date getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(Date registerAt) {
        this.registerAt = registerAt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCurrentToken() {
        return currentToken;
    }

    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken == null ? null : currentToken.trim();
    }
}