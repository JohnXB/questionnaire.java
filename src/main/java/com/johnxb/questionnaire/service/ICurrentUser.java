package com.johnxb.questionnaire.service;

import com.johnxb.questionnaire.entity.AuthUser;

public interface ICurrentUser {
    boolean isAdmin(String token);
    boolean isUser(String token);
    int getUserId(String token);
    AuthUser getUser(String token);
}
