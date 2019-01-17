package com.xlearn.controller;

import com.google.common.collect.Maps;
import com.xlearn.common.Const;
import com.xlearn.common.ServerResponse;
import com.xlearn.pojo.Reward;
import com.xlearn.pojo.User;
import com.xlearn.service.IRewardService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 奖品管理类
 * @Author 谢轩辚
 */
@Controller
@RequestMapping("/reward/")
public class RewardController {

    @Autowired
    private IRewardService iRewardService;

    /**
     * 添加奖品
     *
     * @param reward
     * @return
     */
    @RequestMapping("addReward")
    @ResponseBody
    public ServerResponse<Reward> addReward(HttpSession session, Reward reward) {
        //todo 加上奖品封面
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getUserRole() != Const.Role.ROLE_ADMIN) {
            return ServerResponse.createByErrorMessage("用户尚未登陆或权限不足");
        }
        return iRewardService.addReward(reward);
    }

    /**
     * 删除奖品
     *
     * @param rewardId
     * @return
     */
    @RequestMapping("deleteReward")
    @ResponseBody
    public ServerResponse deleteReward(HttpSession session,Integer rewardId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getUserRole() != Const.Role.ROLE_ADMIN) {
            return ServerResponse.createByErrorMessage("用户尚未登陆或权限不足");
        }
        return iRewardService.deleteReward(rewardId);
    }

    /**
     * 修改奖品
     *
     * @param reward
     * @return
     */
    @RequestMapping("updateReward")
    @ResponseBody
    public ServerResponse<Reward> updateReward(HttpSession session, Reward reward) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getUserRole() != Const.Role.ROLE_ADMIN) {
            return ServerResponse.createByErrorMessage("用户尚未登陆或权限不足");
        }
        return iRewardService.updateReward(reward);
    }

    /**
     * 查找奖品
     *
     * @param keyword
     * @return
     */
    @RequestMapping("selectReward")
    @ResponseBody
    public ServerResponse<List<Reward>> selectReward(HttpSession session, String keyword) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getUserRole() != Const.Role.ROLE_ADMIN) {
            return ServerResponse.createByErrorMessage("用户尚未登陆或权限不足");
        }
        return iRewardService.selectRewardByKeyword(keyword);
    }

    /**
     * 兑换奖品
     * @param session
     * @param rewardId
     * @return
     */
    @RequestMapping("rewardExchange")
    @ResponseBody
    public ServerResponse rewardExchange(HttpSession session, Integer rewardId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getUserRole() != Const.Role.ROLE_ADMIN) {
            return ServerResponse.createByErrorMessage("用户尚未登陆或权限不足");
        }
        return iRewardService.rewardExchange(user,rewardId);
    }

    /**
     * 获取奖品列表
     * @return
     */
    @RequestMapping("listReward")
    @ResponseBody
    public String listReward(HttpSession session) {
        //Todo 业务放到Service。时间格式转换。
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //返回值是map，固定有msg/code/data/count四个元素。
        Map<String, Object> map = Maps.newHashMap();
        //判断用户是否登陆闭关判断用户权限
        if (user == null || user.getUserRole() != Const.Role.ROLE_ADMIN) {
            map.put("msg", "用户未登录或权限不足");
            map.put("code", 0);
            map.put("data", null);
            map.put("count", 0);
            return "用户未登录或权限不足，获取奖品列表失败";
        }

        List<Reward> rewardList = iRewardService.getRewardList().getData();
        if (rewardList != null && rewardList.size() > 0) {
            JSONArray json = new JSONArray();
            //将集合变为json
            for (Reward reward : rewardList) {
                JSONObject jo = new JSONObject();
                jo.put("reward_id", reward.getRewardId());
                jo.put("reward_name", reward.getRewardName());
                jo.put("reward_consume", reward.getRewardConsume());
                jo.put("reward_stock", reward.getRewardStock());
                jo.put("create_time", reward.getCreateTime());
                json.put(jo);
            }

            //将数据准备好layUI的格式
            JSONObject jobj = new JSONObject();
            jobj.put("code",0);
            jobj.put("msg","获取奖品列表成功");
            jobj.put("count",rewardList.size());
            jobj.put("data",json);

            return jobj.toString();

        }
        map.put("msg", "");
        map.put("code", 0);
        map.put("data", null);
        map.put("count", 0);
        return map.toString();
    }
}
