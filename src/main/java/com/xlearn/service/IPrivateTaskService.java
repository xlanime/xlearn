package com.xlearn.service;

import com.xlearn.common.ServerResponse;
import com.xlearn.pojo.PrivateTask;
import com.xlearn.pojo.Task;

import java.util.List;

/**
 * 任务管理接口
 * @Author 谢轩辚
 */
public interface IPrivateTaskService {
    /**
     * 新增任务
     * @param task
     * @return
     */
    ServerResponse<PrivateTask> addTask(PrivateTask task);

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
    ServerResponse<PrivateTask> updateTask(PrivateTask task);

    /**
     * 查找任务
     * @param keyword
     * @return
     */
    ServerResponse<List<PrivateTask>> findTask(String keyword);

    /**
     * 获取任务列表
     * @return
     */
    ServerResponse<List<PrivateTask>> getTaskList(Integer userId);

    /**
     * 完成任务
     * @return
     */
    ServerResponse<PrivateTask> finishTask(Integer taskId, Integer userId);
}
