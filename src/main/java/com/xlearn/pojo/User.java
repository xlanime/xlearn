package com.xlearn.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 * @Author 谢轩辚
 */
@Data
public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String nickName;

    private String sex;

    private String userHead;

    private Integer userPoints;

    private Date registTime;

    private Date lastLogin;

    private Integer userRole;

    private Date createTime;

    private Date updateTime;

    public User(Integer userId, String userName, String password, String nickName, String sex, String userHead,Integer userPoints, Date registTime, Date lastLogin, Integer userRole, Date createTime, Date updateTime) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.sex = sex;
        this.userHead = userHead;
        this.userPoints = userPoints;
        this.registTime = registTime;
        this.lastLogin = lastLogin;
        this.userRole = userRole;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User() {
        super();
    }

}