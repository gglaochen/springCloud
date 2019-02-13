package com.example.cloudconsumer.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootConfiguration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced // Ribbon
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
