package com.xlearn.service;

import com.xlearn.common.ServerResponse;
import com.xlearn.pojo.User;

public interface IUserService {

    /**
     *  用户登录接口
     *  @param username
     *  @param password
     *  @return
     */
    ServerResponse<User> userLogin(String username, String password);

    /**
     *  用户注册接口
     *  @param user
     *  @return
     */
    ServerResponse<User> userRegist(User user);

    /**
     *  修改用户信息
     *  @param user
     *  @return
     */
    ServerResponse<User> updateUserInfo(User user);

    /**
     *  获取用户信息
     *  @param userId
     *  @return
     */
    ServerResponse<User> getUserInfo(Integer userId);

    /**
     *  获取积分排行
     *  @return
     */
    String getRankInfo();
}
