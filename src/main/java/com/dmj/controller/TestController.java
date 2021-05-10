package com.dmj.controller;

import com.dmj.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Test控制类")
@RestController//没有页面，返回的是一个字符串
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "hello,Spring Boot and Swagger!";
    }

    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }

    //Operation接口是放在方法上，而不是类上
    @ApiOperation("hello控制类")
    @GetMapping(value = "/hello")
    public String hello(@ApiParam("用户名") String username){
        return "hello,SpringBoot!!"+username;
    }

    @ApiOperation("Post测试类")
    @GetMapping(value = "/post")
    public User post(@ApiParam("用户名") User user){
        return user;
    }
}
