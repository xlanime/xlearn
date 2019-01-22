package com.xlearn.controller;


import com.xlearn.common.Const;
import com.xlearn.common.ServerResponse;
import com.xlearn.pojo.User;
import com.xlearn.service.IUserService;
import com.xlearn.util.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

/**
 * 用户管理类
 * @Author 谢轩辚
 */
@RequestMapping("/user/")
@Controller
@Slf4j
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     * @param session
     * @param user
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public ServerResponse<User> userLogin(HttpSession session,User user){
        ServerResponse<User> serverResponse =iUserService.userLogin(user.getUserName(),user.getPassword());
        //如果登录成功将用户信息存到session
        if(serverResponse.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,serverResponse.getData());
        }
        return serverResponse;
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("regist")
    @ResponseBody
    public ServerResponse<User> userRegist(User user){
        user.setUserPoints(0);
        return iUserService.userRegist(user);
    }

    /**
     * 用户注销
     * @param session
     * @return
     */
    @RequestMapping("logout")
    public String userLogout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return "user/login";
    }

    /**
     * 修改个人信息
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("updateUserInfo")
    @ResponseBody
    public ServerResponse updateUserInfo(User user,HttpSession session){
        //Todo 逻辑部分放到service当中去
        User userObj = (User) session.getAttribute(Const.CURRENT_USER);
        if(userObj == null) {
            return ServerResponse.createByErrorMessage("用户尚未登录");
        }
        //判断是否是当前用户修改自己的信息
        if(userObj.getUserId().equals(user.getUserId())){
            //判断用户是否修改密码。
            if(!user.getPassword().equals(userObj.getPassword())) {
                user.setPassword(Md5Util.Md5EncodeUtf8(user.getPassword()));
            }
            return iUserService.updateUserInfo(user);
        }
        return ServerResponse.createByErrorMessage("请求错误：无法修改他人信息。");
    }

    /**
     * 获取个人信息
     * @param session
     * @return
     */
    @RequestMapping("getUserInfo")
    @ResponseBody
    public ServerResponse getUserInfo(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if(user != null) {
            return iUserService.getUserInfo(user.getUserId());
        }
        return ServerResponse.createByErrorMessage("用户尚未登录");
    }

    /**
     * 获取用户积分排行
     * @param session
     * @return
     */
    @RequestMapping("pointsRank")
    @ResponseBody
    public String pointsRank(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user != null) {
            return iUserService.getRankInfo();
        }
        log.error("当前用户尚未登录");
        return null;
    }
}
