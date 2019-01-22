package com.xlearn.dao;

import com.xlearn.pojo.Group;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author Richard
 */
@Mapper
@Component(value = "groupMapper")
public interface GroupMapper {
    int deleteByPrimaryKey(Integer groupId);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Integer groupId);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
}