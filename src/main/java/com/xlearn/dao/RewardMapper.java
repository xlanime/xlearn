package com.xlearn.dao;

import com.xlearn.pojo.Reward;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component(value = "rewardMapper")
public interface RewardMapper {
    int deleteByPrimaryKey(Integer rewardId);

    int insert(Reward record);

    int insertSelective(Reward record);

    Reward selectByPrimaryKey(Integer rewardId);

    int updateByPrimaryKeySelective(Reward record);

    int updateByPrimaryKey(Reward record);

    List<Reward> getRewardList();

    List<Reward> selectByKeyword(String keyword);
}