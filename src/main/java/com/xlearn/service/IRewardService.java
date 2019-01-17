package com.xlearn.service;

import com.xlearn.common.ServerResponse;
import com.xlearn.pojo.Reward;
import com.xlearn.pojo.User;

import java.util.List;

public interface IRewardService {

    ServerResponse<Reward> addReward(Reward reward);

    ServerResponse deleteReward(Integer rewardId);

    ServerResponse<Reward> updateReward(Reward reward);

    ServerResponse<List<Reward>> selectRewardByKeyword(String keyword);

    ServerResponse<List<Reward>> getRewardList();

    ServerResponse rewardExchange(User user,Integer rewardId);
}
