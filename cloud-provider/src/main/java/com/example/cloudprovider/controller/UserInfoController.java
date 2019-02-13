package com.example.cloudprovider.controller;

import com.example.cloudprovider.domain.UserInfo;
import com.example.cloudprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @Autowired
    private UserService userService;

    @GetMapping("user/{id}")
    public UserInfo getUser(@PathVariable("id") Integer userId) {
        return userService.getUser(userId);
    }
}
