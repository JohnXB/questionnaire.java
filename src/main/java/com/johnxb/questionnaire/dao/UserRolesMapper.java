package com.johnxb.questionnaire.dao;

import com.johnxb.questionnaire.entity.UserRoles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoles record);

    UserRoles selectByPrimaryKey(Integer id);

    List<UserRoles> selectAll();

    int updateByPrimaryKey(UserRoles record);

    List<String> getRolesByUserId(@Param("user_id") int user_id);

    int insertUserRole(@Param("user_id") int user_id, @Param("role_id") int role_id);
}