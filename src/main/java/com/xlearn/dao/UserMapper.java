package com.xlearn.dao;

import com.xlearn.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户数据库映射类
 * @Author 谢轩辚
 */
@Component("userMapper")
@Mapper
public interface UserMapper {
    /**
     * 根据主键删除用户
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 新增用户
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 新增用户
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 根据主键查找用户
     * @param userId
     * @return
     */
    User selectByPrimaryKey(Integer userId);

    /**
     * 修改用户指定数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 修改用户数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    Integer selectByUsername(String userName);

    /**
     * 根据用户名密码查找用户
     * @param username
     * @param password
     * @return
     */
    User selectByUsernamePassword(@Param(value = "username")String username, @Param(value = "password") String password);

    /**
     * 根据用户ID查询用户当前积分
     * @param userId
     * @return
     */
    Integer getUserPointsByUserId(Integer userId);

    /**
     * 获取积分排名列表
     * @return
     */
    List<User> getRankInfo();
}