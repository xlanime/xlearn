package com.xlearn.controller;

import com.google.common.collect.Maps;
import com.xlearn.common.Const;
import com.xlearn.common.ResponseCode;
import com.xlearn.common.ServerResponse;
import com.xlearn.pojo.Task;
import com.xlearn.pojo.User;
import com.xlearn.service.ITaskService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 任务管理类
 * @Author 谢轩辚
 */
@Controller
@RequestMapping("/task/")
public class TaskController {

    @Autowired
    private ITaskService iTaskService;

    /**
     * 新增任务
     * @return
     */
    @RequestMapping("addTask")
    @ResponseBody
    public ServerResponse addTask(Task task, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        //默认设置完成状态为未完成
        task.setFinished(0);
        return iTaskService.addTask(task);
    }

    /**
     * 删除任务
     * @return
     */
    @RequestMapping("deleteTask")
    @ResponseBody
    public ServerResponse deleteTask(Integer taskId,HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iTaskService.deleteTask(taskId);
    }

    /**
     * 修改任务
     * @return
     */
    @RequestMapping("updateTask")
    @ResponseBody
    public ServerResponse<Task> updateTask(Task task,HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iTaskService.updateTask(task);
    }

    /**
     * 根据关键词查找任务
     * @return
     */
    @RequestMapping("findTask")
    @ResponseBody
    public ServerResponse<List<Task>> findTask(String keyword,HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iTaskService.findTask(keyword);
    }

    /**
     * 获取任务列表
     * @return
     */
    @RequestMapping("taskList")
    @ResponseBody
    public String taskList(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //返回值是map，固定有msg/code/data/count四个元素。
        Map<String, Object> map = Maps.newHashMap();
        if (user == null) {
            map.put("msg", "用户未登录");
            map.put("code", 0);
            map.put("data", null);
            map.put("count", 0);
            return "用户未登录，获取任务列表失败";
        }

        List<Task> taskList = iTaskService.getTaskList().getData();
        if (taskList != null && taskList.size() > 0) {
            map.put("msg", "获取奖品列表成功");
            map.put("code", 0);
            JSONArray json = new JSONArray();
            //将集合变为json
            for (Task task : taskList) {
                JSONObject jo = new JSONObject();
                jo.put("task_id", task.getTaskId());
                jo.put("task_name", task.getTaskName());
                jo.put("task_points", task.getTaskPoints());
                jo.put("task_value", task.getTaskValue());
                jo.put("task_time", task.getTaskTime());
                jo.put("create_time", task.getCreateTime());
                json.put(jo);
            }

            map.put("data", json);
            map.put("count", taskList.size());

            //将数据准备好layUI的格式
            JSONObject jobj = new JSONObject();
            jobj.put("code",0);
            jobj.put("msg","");
            jobj.put("count",taskList.size());
            jobj.put("data",json);

            return jobj.toString();

        }
        map.put("msg", "");
        map.put("code", 0);
        map.put("data", new JSONObject());
        map.put("count", 0);
        return map.toString();
    }

    /**
     * 完成任务
     * @param taskId
     * @param session
     * @return
     */
    @RequestMapping("finishTask")
    @ResponseBody
    public ServerResponse<Task> finishTask(Integer taskId,HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iTaskService.finishTask(taskId,user.getUserId());
    }
}
