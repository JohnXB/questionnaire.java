package com.johnxb.questionnaire.dao;

import com.johnxb.questionnaire.entity.RolePermissions;
import java.util.List;

public interface RolePermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermissions record);

    RolePermissions selectByPrimaryKey(Integer id);

    List<RolePermissions> selectAll();

    int updateByPrimaryKey(RolePermissions record);
}