package com.johnxb.questionnaire.dao;

import com.johnxb.questionnaire.entity.AuthUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface AuthUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthUser record);

    AuthUser selectByPrimaryKey(Integer id);

    List<AuthUser> selectAll();

    int updateByPrimaryKey(AuthUser record);
    List<String> selectByUsername(@Param("username")String username);
    AuthUser selectBySignIn(AuthUser user);

}