package com.xlearn.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 任务实体类
 * @Author 谢轩辚
 */
@Data
public class Task {
    private Integer taskId;

    private Integer taskPoints;

    private String taskName;

    private String taskValue;

    private String taskCover;

    private Integer taskTime;

    private Integer finished;

    private Date createTime;

    private Date updateTime;

    public Task(Integer taskId, Integer taskPoints, String taskName, String taskValue, String taskCover,
                Integer taskTime, Integer finished,Date createTime, Date updateTime) {
        this.taskId = taskId;
        this.taskPoints = taskPoints;
        this.taskName = taskName;
        this.taskValue = taskValue;
        this.taskCover = taskCover;
        this.taskTime = taskTime;
        this.finished = finished;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Task() {
        super();
    }

}