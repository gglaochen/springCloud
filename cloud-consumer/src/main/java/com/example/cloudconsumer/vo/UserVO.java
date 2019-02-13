package com.example.cloudconsumer.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserVO {
    private Integer userId;
    private String userName;
    private Date userBirth;
}
