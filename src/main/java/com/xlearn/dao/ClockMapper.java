package com.xlearn.dao;

import com.xlearn.pojo.Clock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 计时类DAO层
 * @Author 谢轩辚
 */
@Mapper
@Component(value = "clockMapper")
public interface ClockMapper {
    /**
     * 根据主键删除计时信息
     * @param clockId
     * @return
     */
    int deleteByPrimaryKey(Integer clockId);

    /**
     * 新增计时信息
     * @param record
     * @return
     */
    int insert(Clock record);

    /**
     * 新增指定计时信息
     * @param record
     * @return
     */
    int insertSelective(Clock record);

    /**
     * 根据主键查询计时信息
     * @param clockId
     * @return
     */
    Clock selectByPrimaryKey(Integer clockId);

    /**
     * 根据主键更新指定内容
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Clock record);

    /**
     * 根据主键更新内容
     * @param record
     * @return
     */
    int updateByPrimaryKey(Clock record);

    /**
     * 获取指定用户所有计时信息
     * @param userId
     * @return
     */
    List<Clock> getClockInfoByUserId(Integer userId);
}