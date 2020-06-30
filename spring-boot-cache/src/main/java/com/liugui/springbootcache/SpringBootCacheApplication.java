package com.liugui.springbootcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan(basePackages = {"com.liugui.springbootcache.mapper"})
@EntityScan(basePackages = {"com.liugui"})
@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching//开启缓存注解
public class SpringBootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheApplication.class, args);
    }

}
