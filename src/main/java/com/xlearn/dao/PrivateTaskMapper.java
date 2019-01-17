package com.xlearn.dao;

import com.xlearn.pojo.PrivateTask;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 任务管理DAO层
 * @Author 谢轩辚
 */
@Mapper
@Component(value = "privateTaskMapper")
public interface PrivateTaskMapper {
    /**
     * 根据主键删除任务
     * @param taskId
     * @return
     */
    int deleteByPrimaryKey(Integer taskId);

    /**
     * 新增任务
     * @param record
     * @return
     */
    int insert(PrivateTask record);

    /**
     * 新增指定内容的任务
     * @param record
     * @return
     */
    int insertSelective(PrivateTask record);

    /**
     * 根据主键查找
     * @param taskId
     * @return
     */
    PrivateTask selectByPrimaryKey(Integer taskId);

    /**
     * 根据主键修改任务指定内容
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PrivateTask record);

    /**
     * 根据主键修改任务
     * @param record
     * @return
     */
    int updateByPrimaryKey(PrivateTask record);

    /**
     * 根据关键词查找任务
     * @param keyword
     * @return
     */
    List<PrivateTask> selectByKeyword(String keyword);

    /**
     * 获取任务列表
     * @param userId
     * @return
     */
    List<PrivateTask> getTaskList(Integer userId);
}