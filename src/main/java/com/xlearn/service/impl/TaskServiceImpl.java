package com.xlearn.service.impl;

import com.xlearn.common.ServerResponse;
import com.xlearn.dao.TaskMapper;
import com.xlearn.dao.UserMapper;
import com.xlearn.pojo.Task;
import com.xlearn.pojo.User;
import com.xlearn.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 任务管理接口实现类
 * @Author 谢轩辚
 */
@Service("iTaskService")
@Slf4j
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<Task> addTask(Task task){
        int rowCount = taskMapper.insert(task);
        if(rowCount > 0){
            return ServerResponse.createBySuccess("创建任务成功",task);
        }
        return ServerResponse.createByErrorMessage("创建任务失败");
    }

    @Override
    public ServerResponse deleteTask(Integer taskId) {
        int rowCount = taskMapper.deleteByPrimaryKey(taskId);
        if(rowCount > 0){
            return ServerResponse.createBySuccessMessage("删除任务成功");
        }
        return ServerResponse.createByErrorMessage("删除任务失败");
    }

    @Override
    public ServerResponse<Task> updateTask(Task task) {
        int rowCount = taskMapper.updateByPrimaryKeySelective(task);
        if(rowCount > 0){
            return ServerResponse.createBySuccessMessage("修改任务成功");
        }
        return ServerResponse.createByErrorMessage("修改任务失败");
    }

    @Override
    public ServerResponse<List<Task>> findTask(String keyword) {
        List<Task> taskList = taskMapper.selectByKeyword(keyword);
        if(taskList != null && taskList.size()>0){
            return ServerResponse.createBySuccess("搜索任务成功",taskList);
        }
        return ServerResponse.createByErrorMessage("未查找到相关的信息");
    }

    @Override
    public ServerResponse<List<Task>> getTaskList() {
        List<Task> taskList = taskMapper.getTaskList();
        if(taskList != null && taskList.size()>0){
            return ServerResponse.createBySuccess("获取任务列表成功",taskList);
        }
        return ServerResponse.createByErrorMessage("获取任务列表失败");
    }

    @Override
    public ServerResponse<Task> finishTask(Integer taskId,Integer userId) {
        Task task = taskMapper.selectByPrimaryKey(taskId);
        //获取到任务的奖励积分数
        int taskPoints = task.getTaskPoints();
        //将奖励积分加到用户积分中并更新用户积分
        User user = userMapper.selectByPrimaryKey(userId);
        log.info("用户当前积分："+user.getUserPoints());
        Integer points = user.getUserPoints() == null?0:user.getUserPoints() + taskPoints;
        log.info("本次获得积分："+taskPoints+"，当前积分更新为："+points);
        user.setUserPoints(points);
        int userUpdateCount = userMapper.updateByPrimaryKey(user);
        if(userUpdateCount > 0){
            log.info("更新用户积分成功，删除以完成任务");
            //如果任务次数为1则完成任务,否则任务次数减一
            if(task.getTaskTime() == 1){
                task.setFinished(1);
                int rowCount = taskMapper.updateByPrimaryKeySelective(task);
                if(rowCount > 0){
                    log.info("删除任务成功");
                }
            }else{
                task.setTaskTime(task.getTaskTime()-1);
                int rowCount = taskMapper.updateByPrimaryKeySelective(task);
                if(rowCount > 0){
                    log.info("更新任务成功，当前任务次数{}",task.getTaskTime());
                }
            }
            return ServerResponse.createBySuccess("任务完成！",task);
        }
        return ServerResponse.createByErrorMessage("任务完成出错，请联系管理员！");
    }
}
