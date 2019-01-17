package com.xlearn.service;

import com.xlearn.common.ServerResponse;
import com.xlearn.pojo.Clock;
import com.xlearn.pojo.User;

import java.util.List;

/**
 * 计时服务类
 * @Author 谢轩辚
 */
public interface IClockService {

    /**
     * 开始计时
     * @param userId
     * @return
     */
    ServerResponse<Integer> startClock(Integer userId);

    /**
     * 结束计时
     * @param clockId
     * @param userId
     * @return
     */
    ServerResponse endClock(Integer clockId,Integer userId);

    /**
     * 根据用户ID获取当前用户所有打卡计时信息.
     * @param userId
     * @return
     */
    List<Clock> getClockInfoByUserId(Integer userId);

    /**
     * 自动添加积分
     * @param user
     * @return
     */
    ServerResponse autoSavePoints(User user);
}
