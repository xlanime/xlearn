package com.xlearn.service.impl;

import com.xlearn.common.ServerResponse;
import com.xlearn.dao.RewardMapper;
import com.xlearn.dao.RewardRecordMapper;
import com.xlearn.dao.UserMapper;
import com.xlearn.pojo.Reward;
import com.xlearn.pojo.RewardRecord;
import com.xlearn.pojo.User;
import com.xlearn.service.IRewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iRewardService")
public class RewardServiceImpl implements IRewardService{

    @Autowired
    private RewardMapper rewardMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RewardRecordMapper rewardRecordMapper;

    @Override
    public ServerResponse<Reward> addReward(Reward reward) {
        int rowCount = rewardMapper.insert(reward);
        if(rowCount > 0){
            return ServerResponse.createBySuccess("添加奖品成功",reward);
        }
        return ServerResponse.createByErrorMessage("添加奖品失败");
    }

    @Override
    public ServerResponse deleteReward(Integer rewardId) {
        int rowCount = rewardMapper.deleteByPrimaryKey(rewardId);
        if(rowCount > 0){
            return ServerResponse.createBySuccessMessage("删除奖品成功");
        }
        return ServerResponse.createByErrorMessage("删除奖品失败");
    }

    @Override
    public ServerResponse<Reward> updateReward(Reward reward) {
        int rowCount = rewardMapper.updateByPrimaryKeySelective(reward);
        if(rowCount > 0){
            return ServerResponse.createBySuccess("修改奖品成功",reward);
        }
        return ServerResponse.createByErrorMessage("修改奖品失败");
    }

    @Override
    public ServerResponse<List<Reward>> selectRewardByKeyword(String keyword) {
        List<Reward> rewardList = rewardMapper.selectByKeyword(keyword);
        if(rewardList!=null && rewardList.size()>0){
            return ServerResponse.createBySuccess(rewardList);
        }
        return ServerResponse.createBySuccessMessage("未找到相关奖品");
    }

    @Override
    public ServerResponse<List<Reward>> getRewardList() {
        List<Reward> rewardList = rewardMapper.getRewardList();
        if(rewardList!=null && rewardList.size()>0){
            return ServerResponse.createBySuccess(rewardList);
        }
        return ServerResponse.createBySuccessMessage("尚无奖品");
    }

    @Override
    public ServerResponse rewardExchange(User user,Integer rewardId){
        //获取到用户的积分
        Integer points = userMapper.getUserPointsByUserId(user.getUserId());
        //获取到要兑换的奖品
        Reward reward = rewardMapper.selectByPrimaryKey(rewardId);
        if(points < reward.getRewardConsume()){
            return ServerResponse.createByErrorMessage("积分不足，无法兑换");
        }
        //扣除积分
        points = points - reward.getRewardConsume();
        user.setUserPoints(points);
        //更新用户积分
        userMapper.updateByPrimaryKeySelective(user);
        //将兑换记录保存到数据库
        RewardRecord rewardRecord = new RewardRecord();
        rewardRecord.setRecordReward(rewardId);
        rewardRecord.setRecordUser(user.getUserId());
        rewardRecordMapper.insert(rewardRecord);

        //更新库存
        reward.setRewardStock(reward.getRewardStock()-1);
        rewardMapper.updateByPrimaryKeySelective(reward);
        return ServerResponse.createBySuccessMessage("兑换成功");
    }
}
