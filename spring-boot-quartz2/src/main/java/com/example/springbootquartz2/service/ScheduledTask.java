package com.example.springbootquartz2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ScheduledTask
 * @Author: liugui
 * @Date: 2020-09-18 10:53
 **/
@Slf4j
@Configuration
@Component
@EnableScheduling
public class ScheduledTask {

    public void sayHello(){
        log.info("Hello world, i'm the king of the world!!!");
    }

}
