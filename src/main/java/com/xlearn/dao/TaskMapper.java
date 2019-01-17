package com.xlearn.dao;

import com.xlearn.pojo.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 任务管理DAO层
 * @Author 谢轩辚
 */
@Mapper
@Component(value = "taskMapper")
public interface TaskMapper {
    /**
     * 根据主键删除任务
     * @param taskId
     * @return
     */
    int deleteByPrimaryKey(Integer taskId);

    /**
     * 插入任务
     * @param record
     * @return
     */
    int insert(Task record);

    /**
     * 插入任务的指定内容
     * @param record
     * @return
     */
    int insertSelective(Task record);

    /**
     * 根据主键查找任务
     * @param taskId
     * @return
     */
    Task selectByPrimaryKey(Integer taskId);

    /**
     * 修改任务的指定内容
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Task record);

    /**
     * 修改任务
     * @param record
     * @return
     */
    int updateByPrimaryKey(Task record);

    /**
     * 根据关键词查找任务
     * @param keyword
     * @return
     */
    List<Task> selectByKeyword(String keyword);

    /**
     * 获取任务列表
     * @return
     */
    List<Task> getTaskList();

}