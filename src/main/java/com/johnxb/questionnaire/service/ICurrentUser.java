package com.johnxb.questionnaire.service;

public interface ICurrentUser {
    boolean isAdmin(String token);
    boolean isUser(String token);
    int getUserId(String token);
}
