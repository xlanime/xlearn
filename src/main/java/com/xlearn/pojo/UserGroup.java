package com.xlearn.pojo;

import java.util.Date;

public class UserGroup {
    private Integer memGroupId;

    private Integer groupId;

    private Integer userId;

    private Date createTime;

    private Date updateTime;

    public UserGroup(Integer memGroupId, Integer groupId, Integer userId, Date createTime, Date updateTime) {
        this.memGroupId = memGroupId;
        this.groupId = groupId;
        this.userId = userId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public UserGroup() {
        super();
    }

    public Integer getMemGroupId() {
        return memGroupId;
    }

    public void setMemGroupId(Integer memGroupId) {
        this.memGroupId = memGroupId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}