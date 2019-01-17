package com.xlearn.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Group {
    private Integer groupId;

    private String groupName;

    private String groupRemark;

    private Date createTime;

    private Date updateTime;

    public Group(Integer groupId, String groupName, String groupRemark, Date createTime, Date updateTime) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupRemark = groupRemark;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Group() {
        super();
    }

}