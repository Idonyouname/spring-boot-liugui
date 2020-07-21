package com.liugui.springbootonlinelog2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.liugui.springbootonlinelog2.mapper")
@SpringBootApplication
public class SpringBootOnlineLog2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOnlineLog2Application.class, args);
    }

}
