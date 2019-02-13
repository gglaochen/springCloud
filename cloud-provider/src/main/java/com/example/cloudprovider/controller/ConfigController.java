package com.example.cloudprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 实现局部刷新配置
public class ConfigController {

    @Value("${label}")
    private String label;

    @GetMapping("/config")
    public String test() {
        return "config->"+label;
    }
}
