package com.example.serviceaaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceAaaApplication {

    @GetMapping("/ccc")
    public String ccc(){
        return "Im ccc server";
    }
    public static void main(String[] args) {
        SpringApplication.run(ServiceAaaApplication.class, args);
    }

}

