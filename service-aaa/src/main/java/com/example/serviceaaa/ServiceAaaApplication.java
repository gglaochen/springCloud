package com.example.serviceaaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.PublicKey;

@SpringBootApplication
@RestController
public class ServiceAaaApplication {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/aaa")
    public String aaa(){
        return "Im aaa server";
    }

    @GetMapping("/link/bbb")
    public String aaa_bbb(){
        return restTemplate().getForObject("http://localhost:8003/bbb",String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceAaaApplication.class, args);
    }

}

