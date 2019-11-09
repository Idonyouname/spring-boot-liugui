package com.example.springbootadminclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAdminClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminClientApplication.class, args);
        System.out.println("-----------------------admin监控客户端启动-----------------------");
    }

}
