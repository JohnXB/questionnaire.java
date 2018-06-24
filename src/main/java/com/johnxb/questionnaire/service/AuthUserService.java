package com.johnxb.questionnaire.service;

import com.johnxb.questionnaire.entity.AuthUser;

public interface AuthUserService {
    AuthUser findByUserId(int id);
    boolean signUp(AuthUser user);
}
