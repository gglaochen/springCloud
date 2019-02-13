package com.example.cloudprovider.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserInfo {
    private Integer userId;
    private String userName;
    private Date userBirth;
}
