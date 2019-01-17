package com.xlearn.service;

import com.xlearn.common.ServerResponse;
import com.xlearn.pojo.Task;

import java.util.List;

/**
 * 任务管理接口
 * @Author 谢轩辚
 */
public interface ITaskService {
    /**
     * 新增任务
     * @param task
     * @return
     */
    ServerResponse<Task> addTask(Task task);

    /**
     * 删除任务
     * @param taskId
     * @return
     */
    ServerResponse deleteTask(Integer taskId);

    /**
     * 修改任务
     * @param task
     * @return
     */
    ServerResponse<Task> updateTask(Task task);

    /**
     * 查找任务
     * @param keyword
     * @return
     */
    ServerResponse<List<Task>> findTask(String keyword);

    /**
     * 获取任务列表
     * @return
     */
    ServerResponse<List<Task>> getTaskList();

    /**
     * 完成任务
     * @param taskId
     * @param userId
     * @return
     */
    ServerResponse<Task> finishTask(Integer taskId,Integer userId);
}
