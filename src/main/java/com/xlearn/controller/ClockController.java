package com.xlearn.controller;

import com.google.common.collect.Maps;
import com.xlearn.common.Const;
import com.xlearn.common.ServerResponse;
import com.xlearn.pojo.Clock;
import com.xlearn.pojo.User;
import com.xlearn.service.IClockService;
import com.xlearn.util.PointUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/clock/")
public class ClockController {

    @Autowired
    private IClockService iClockService;

    @RequestMapping("start")
    public String startClock(HttpSession session, HttpServletResponse response) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            log.warn("用户尚未登录");
            return "user/login";
        }
        ServerResponse<Integer> serverResponse = iClockService.startClock(user.getUserId());
        if (serverResponse.isSuccess()) {
            Cookie cookie_timer = new Cookie(Const.CURRENT_TIMER, serverResponse.getData().toString());
            Cookie cookie_user = new Cookie(Const.CURRENT_USER, user.getUserId().toString());
            //将用户信息和计时信息放到cookie。设计过期时间为一个月
            cookie_timer.setMaxAge(30 * 24 * 60 * 60);
            cookie_user.setMaxAge(30 * 24 * 60 * 60);
            response.addCookie(cookie_timer);
            response.addCookie(cookie_user);
            session.setAttribute(Const.CURRENT_TIMER, serverResponse.getData());
            return "time/timer";
        }
        return "user/index";
    }

    /**
     * 结束计时并积分
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("end")
    public String endClock(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        Integer clockId = (Integer) session.getAttribute(Const.CURRENT_TIMER);
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            //从cookie取值
            Cookie[] cookies = request.getCookies();
            Integer userId = -1;
            Integer timerId = -1;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Const.CURRENT_USER)) {
                    userId = Integer.valueOf(cookie.getValue());
                    //清除cookie防止重复计分
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                if (cookie.getName().equals(Const.CURRENT_TIMER)) {
                    timerId = Integer.valueOf(cookie.getValue());
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            if(userId == -1 && timerId == -1){
                log.warn("cookie已失效，不再计分。返回登陆界面");
                return "user/login";
            }
            ServerResponse serverResponse = iClockService.endClock(timerId, userId);
            if (!serverResponse.isSuccess()) {
                log.warn("用户尚未登录或登录失效,计分失败");
            } else {
                log.info("用户尚未登录或登录失效,计分成功");
            }
            return "user/login";
        }
        ServerResponse serverResponse = iClockService.endClock(clockId, user.getUserId());
        if (serverResponse.isSuccess()) {
            return "time/finish";
        }
        return "time/timer";
    }

    /**
     * 保持session在线,6分钟自动加1积分
     *
     * @return
     */
    @RequestMapping("keepClock")
    @ResponseBody
    public String keepClock(String msg,HttpSession session) {
        log.info("recive msg"+msg);
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return "user/login";
        }
        iClockService.autoSavePoints(user);
        return "保存积分成功";
    }

    /**
     * 获取用户在线学习总时间
     * @return
     */
    @RequestMapping("learnTime")
    @ResponseBody
    public String learnTime(HttpSession session) {
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return "用户尚未登录";
        }
        List<Clock> clockList = iClockService.getClockInfoByUserId(user.getUserId());
        //初始化总时间
        int generalTime = 0;
        //遍历计算学习总时间
        for(Clock clock:clockList){
            //如果开始和结束时间一样，则说明计时还未结束或异常结束，不计算到学习总时间
            if(!PointUtil.sameTime(clock.getBeginTime(),clock.getEndTime())){
                generalTime += PointUtil.getTimeDiff(clock.getBeginTime(),clock.getEndTime());
            }
        }
        //将毫秒转换成秒
        generalTime = generalTime/1000;
        String timeStr = PointUtil.secondsToTimeString(generalTime);
        JSONObject response = new JSONObject();
        response.put("time",timeStr);
        return response.toString();
    }
}
