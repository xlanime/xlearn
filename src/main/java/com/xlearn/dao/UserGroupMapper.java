package com.xlearn.dao;

import com.xlearn.pojo.UserGroup;

public interface UserGroupMapper {
    int deleteByPrimaryKey(Integer memGroupId);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    UserGroup selectByPrimaryKey(Integer memGroupId);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);
}