package com.example.cloudconsumer.client;

import com.example.cloudconsumer.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @FeignClient(name = "provider")
 * name为调用服务端的spring.application.name的值
 */
@FeignClient(name = "api-gateway")
public interface UserClient {
    @GetMapping("myUser/user/{id}")
    UserVO getUserData(@PathVariable("id") Integer userId);
}
