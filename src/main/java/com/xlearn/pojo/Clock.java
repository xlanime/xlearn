package com.xlearn.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Clock {
    private Integer clockId;

    private Date beginTime;

    private Date endTime;

    private Integer userId;

    private Integer points;

    private Date createTime;

    private Date updateTime;

    public Clock(Integer clockId, Date beginTime, Date endTime, Integer userId, Integer points, Date createTime, Date updateTime) {
        this.clockId = clockId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.userId = userId;
        this.points = points;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Clock() {
        super();
    }
}