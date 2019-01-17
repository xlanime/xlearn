package com.xlearn.pojo;

import java.util.Date;

public class PrivateTask {
    private Integer taskId;

    private Integer taskPoints;

    private String taskName;

    private String taskValue;

    private String taskCover;

    private Integer finished;

    private Integer ownerId;

    private Integer taskTime;

    private Date createTime;

    private Date updateTime;

    public PrivateTask(Integer taskId, Integer taskPoints, String taskName, String taskValue, String taskCover, Integer finished, Integer ownerId, Integer taskTime, Date createTime, Date updateTime) {
        this.taskId = taskId;
        this.taskPoints = taskPoints;
        this.taskName = taskName;
        this.taskValue = taskValue;
        this.taskCover = taskCover;
        this.finished = finished;
        this.ownerId = ownerId;
        this.taskTime = taskTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PrivateTask() {
        super();
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskPoints() {
        return taskPoints;
    }

    public void setTaskPoints(Integer taskPoints) {
        this.taskPoints = taskPoints;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getTaskValue() {
        return taskValue;
    }

    public void setTaskValue(String taskValue) {
        this.taskValue = taskValue == null ? null : taskValue.trim();
    }

    public String getTaskCover() {
        return taskCover;
    }

    public void setTaskCover(String taskCover) {
        this.taskCover = taskCover == null ? null : taskCover.trim();
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(Integer taskTime) {
        this.taskTime = taskTime;
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