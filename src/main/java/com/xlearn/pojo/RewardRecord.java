package com.xlearn.pojo;

import java.util.Date;

/**
 * @Author Richard
 */
public class RewardRecord {
    private Integer recordId;

    private Integer recordReward;

    private Integer recordUser;

    private Date createTime;

    private Date updateTime;

    public RewardRecord(Integer recordId, Integer recordReward, Integer recordUser, Date createTime, Date updateTime) {
        this.recordId = recordId;
        this.recordReward = recordReward;
        this.recordUser = recordUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public RewardRecord() {
        super();
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getRecordReward() {
        return recordReward;
    }

    public void setRecordReward(Integer recordReward) {
        this.recordReward = recordReward;
    }

    public Integer getRecordUser() {
        return recordUser;
    }

    public void setRecordUser(Integer recordUser) {
        this.recordUser = recordUser;
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