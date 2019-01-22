package com.xlearn.service.impl;

import com.xlearn.common.ServerResponse;
import com.xlearn.dao.ClockMapper;
import com.xlearn.dao.UserMapper;
import com.xlearn.pojo.Clock;
import com.xlearn.pojo.User;
import com.xlearn.service.IClockService;
import com.xlearn.util.PointUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Richard
 */
@Service("iClockService")
@Slf4j
public class ClockServiceImpl implements IClockService{

    @Autowired
    private ClockMapper clockMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<Integer> startClock(Integer userId) {
        Clock clock = new Clock();
        Date date = new Date();
        clock.setBeginTime(date);
        clock.setEndTime(date);
        clock.setUserId(userId);
        clock.setPoints(0);
        int rowCount = clockMapper.insert(clock);
        if(rowCount > 0){
            return ServerResponse.createBySuccess(clock.getClockId());
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse endClock(Integer clockId,Integer userId) {
        Clock clock = clockMapper.selectByPrimaryKey(clockId);
        //获取当前时间
        Date date = new Date();
        clock.setEndTime(date);
        clock.setUpdateTime(date);
        //设置获取的积分
        Integer currentPoint = PointUtil.getPoint(clock.getBeginTime(),date);
        clock.setPoints(currentPoint);
        int rowCount = clockMapper.updateByPrimaryKey(clock);
        if(rowCount > 0){
            return ServerResponse.createByErrorMessage("更新用户积分失败");
        }
        log.error("结束计时失败");
        return ServerResponse.createByErrorMessage("结束计时失败");
    }

    @Override
    public List<Clock> getClockInfoByUserId(Integer userId) {
        return clockMapper.getClockInfoByUserId(userId);
    }

    @Override
    public ServerResponse autoSavePoints(User user) {
        //更新用户积分
        log.info("用户当前积分："+user.getUserPoints());
        Integer points = user.getUserPoints() == null?0:user.getUserPoints() + 1;
        log.info("本次获得积分：1，当前积分更新为："+points);
        user.setUserPoints(points);
        int userUpdateCount = userMapper.updateByPrimaryKey(user);
        if(userUpdateCount > 0){
            return ServerResponse.createBySuccess();
        }
        log.error("更新用户积分失败");
        return ServerResponse.createByErrorMessage("更新用户积分失败");
    }
}
