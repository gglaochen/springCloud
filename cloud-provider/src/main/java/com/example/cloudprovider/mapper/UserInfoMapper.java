package com.example.cloudprovider.mapper;

import com.example.cloudprovider.domain.UserInfo;

public interface UserInfoMapper {
    UserInfo getUser(Integer userId);
}
