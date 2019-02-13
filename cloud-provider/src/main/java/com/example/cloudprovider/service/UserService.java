package com.example.cloudprovider.service;

import com.example.cloudprovider.domain.UserInfo;

public interface UserService {
    UserInfo getUser(Integer userId);
}
