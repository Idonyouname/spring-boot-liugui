package com.example.springbootrabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @ClassName: QueueConfig
 * @Author: liugui
 * @Date: 2019-11-07 19:29
 **/
@Configuration
public class QueueConfig {
    @Bean
    public Queue simpleQueue(){
        return new Queue("simple");
    }

    @Bean
    public Queue simpleOneToMany() {
        return new Queue("simpleOneToMany");
    }

}
