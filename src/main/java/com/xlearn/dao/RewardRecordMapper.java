package com.xlearn.dao;

import com.xlearn.pojo.RewardRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 奖励兑换记录类
 * @Author 谢轩辚
 */
@Mapper
@Component(value = "rewardRecordMapper")
public interface RewardRecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(RewardRecord record);

    int insertSelective(RewardRecord record);

    RewardRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(RewardRecord record);

    int updateByPrimaryKey(RewardRecord record);
}