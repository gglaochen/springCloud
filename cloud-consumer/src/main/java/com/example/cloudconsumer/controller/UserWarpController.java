package com.example.cloudconsumer.controller;

import com.example.cloudconsumer.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserWarpController {
    @Autowired
    private RestTemplate restTemplate;

    // 调用只有一个或者多个服务实例API的情况下
    @GetMapping("warp/user/{userId}")
    public UserVO getUserData(@PathVariable("userId") Integer userId) {
        return restTemplate.getForObject("http://provider/user/"+userId, UserVO.class);
    }
}
