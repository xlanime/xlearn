package com.xlearn.service.impl;

import com.xlearn.common.ServerResponse;
import com.xlearn.dao.UserMapper;
import com.xlearn.pojo.User;
import com.xlearn.service.IUserService;
import com.xlearn.util.Md5Util;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户逻辑处理类
 * @Author Richard
 */
@Service("iUserService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> userLogin(String username,String password){
        int count = userMapper.selectByUsername(username);
        if(count == 0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }

        //若用户存在则根据用户名密码查询,注意密码需要加密。
        password = Md5Util.Md5EncodeUtf8(password);
        User user = userMapper.selectByUsernamePassword(username,password);
        if(user == null){
            return ServerResponse.createByErrorMessage("用户名或密码错误");
        }
        //不清空密码。用来后面修改的时候比对。
//        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功！",user);
    }

    @Override
    public ServerResponse<User> userRegist(User user) {
        Integer userCheck = userMapper.selectByUsername(user.getUserName());
        //检查用户名是否已存在
        if(userCheck > 0){
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        //给用户密码加密
        user.setPassword(Md5Util.Md5EncodeUtf8(user.getPassword()));
        user.setUserHead("/images/head/0.jpg");
        int rowCount = userMapper.insert(user);
        if(rowCount > 0){
            return ServerResponse.createBySuccess("注册成功",user);
        }
        return ServerResponse.createByErrorMessage("注册失败");
    }

    @Override
    public ServerResponse<User> updateUserInfo(User user) {
        int rowCount = userMapper.updateByPrimaryKeySelective(user);
        if(rowCount > 0){
            return ServerResponse.createBySuccess("更新个人信息成功",user);
        }
        return ServerResponse.createBySuccess("更新个人信息失败",user);
    }

    @Override
    public ServerResponse<User> getUserInfo(Integer userId){
        User user =  userMapper.selectByPrimaryKey(userId);
        if(user != null){
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("获取用户信息失败");
    }

    @Override
    public String getRankInfo(){
        List<User> userList = userMapper.getRankInfo();
        if(userList != null && userList.size()>0){
            //将集合变为json
            JSONArray json = new JSONArray();

            //用户排序
            int sortNum = 1;
            for (User user : userList) {
                JSONObject jo = new JSONObject();
                jo.put("sort_num", sortNum);
                jo.put("nickname", user.getNickName());
                jo.put("user_points", user.getUserPoints());
                json.put(jo);
                sortNum++;
            }

            //将数据准备好layUI的格式
            JSONObject jobj = new JSONObject();
            jobj.put("code",0);
            jobj.put("msg","");
            jobj.put("count",userList.size());
            jobj.put("data",json);
            return jobj.toString();
        }

        JSONObject jobj = new JSONObject();
        jobj.put("code",0);
        jobj.put("msg","当前尚无用户");
        jobj.put("count",0);
        jobj.put("data","");
        return jobj.toString();
    }
}
