package com.example.cloudprovider.service.impl;

import com.example.cloudprovider.domain.UserInfo;
import com.example.cloudprovider.mapper.UserInfoMapper;
import com.example.cloudprovider.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userMapper;

    @Override
    public UserInfo getUser(Integer userId) {
        return userMapper.getUser(userId);
    }
}
