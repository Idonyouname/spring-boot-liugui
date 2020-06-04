package com.example.springbootonlinelog;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.example.springbootonlinelog"})
@SpringBootApplication
public class SpringBootOnlineLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOnlineLogApplication.class, args);
    }

}
