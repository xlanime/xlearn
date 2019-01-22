package com.xlearn.controller;

import com.xlearn.common.Const;
import com.xlearn.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 用于界面跳转的Controller
 *
 * @Author Richard
 */
@RequestMapping("/")
@Controller
public class PageController {

    /**
     * 跳转到系统首页
     * @return
     */
    @RequestMapping("index")
    public String index(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        //用户没有登陆则跳转到登陆界面，否则进入主页
        if(user == null){
            return "user/login";
        }
        return "user/index";
    }

    /**
     * 跳转到欢迎页
     * @return
     */
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    /**
     * 跳转到积分排行榜界面
     * @return
     */
    @RequestMapping("login")
    public String login(){
        return "user/login";
    }

    /**
     * 跳转到奖品兑换界面
     * @return
     */
    @RequestMapping("toRank")
    public String toRank(){
        return "user/pointsRank";
    }

    /**
     * 跳转到注册界面
     * @return
     */
    @RequestMapping("regist")
    public String regist(){
        return "user/regist";
    }

    /**
     * 跳转到计时界面
     * @return
     */
    @RequestMapping("timer")
    public String timer(){
        return "time/timer";
    }

    /**
     * 跳转到修改用户信息界面
     * @return
     */
    @RequestMapping("userInfo")
    public String userInfo(){
        return "user/userInfo";
    }

    /**
     * 跳转到测试界面
     * @return
     */
    @RequestMapping("toTest")
    public String toTest(){
        return "test/open";
    }

    /**
     * 跳转到奖品列表页
     * @return
     */
    @RequestMapping("toReward")
    public String toReward(){
        return "reward/rewardList";
    }

    /**
     * 跳转到奖品兑换界面
     * @return
     */
    @RequestMapping("toRewardExchange")
    public String toRewardExchange(){
        return "reward/rewardExchange";
    }

    /**
     * 跳转到任务列表界面
     * @return
     */
    @RequestMapping("toTask")
    public String toTask(){
        return "task/taskList";
    }

    /**
     * 跳转到个人任务列表界面
     * @return
     */
    @RequestMapping("toPrivateTask")
    public String toPrivateTask(){
        return "ptask/taskList";
    }
}
