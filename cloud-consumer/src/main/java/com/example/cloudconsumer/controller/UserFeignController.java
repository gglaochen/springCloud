package com.example.cloudconsumer.controller;

import com.example.cloudconsumer.client.UserClient;
import com.example.cloudconsumer.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserFeignController {
    @Resource
    private UserClient userClient;

    // 调用只有一个或者多个服务实例API的情况下
    @GetMapping("feign/user/{userId}")
    public UserVO getUserData1(@PathVariable("userId") Integer userId) {
        return userClient.getUserData(userId);
    }
}
