package com.xlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * RESTful接口测试类
 *
 * @Author Richard
 */
@RequestMapping("/test/")
@Controller
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String helloSpringBoot(){
        System.out.println("Hello Spring");
        return "Hello Srping Boot";
    }
}
