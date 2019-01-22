package com.example.serviceaaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ServiceAaaApplication {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/bbb")
    public String bbb(){
        return "Im bbb server";
    }

    @GetMapping("/link/ccc")
    public String bbb_ccc(){
        return restTemplate().getForObject("http://localhost:8004/ccc",String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceAaaApplication.class, args);
    }

}

