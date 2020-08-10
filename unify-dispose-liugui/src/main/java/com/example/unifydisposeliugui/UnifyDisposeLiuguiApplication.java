package com.example.unifydisposeliugui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.example.unifydisposeliugui.mapper"})
@SpringBootApplication
public class UnifyDisposeLiuguiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnifyDisposeLiuguiApplication.class, args);
        System.out.println("*************************************************************************");
        System.out.println("********************统一日志收集、统一异常处理、统一结果返回*********************");
        System.out.println("*************************************************************************");
    }

}
