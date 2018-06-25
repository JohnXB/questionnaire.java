package com.johnxb.questionnaire.service;

import com.johnxb.questionnaire.entity.AuthUser;

public interface AuthUserService {
    AuthUser findByUserName(String username);
    boolean signUp(AuthUser user);
    String signIn(AuthUser user);
}
