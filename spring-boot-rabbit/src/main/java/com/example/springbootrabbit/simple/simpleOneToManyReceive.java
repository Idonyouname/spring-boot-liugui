package com.example.springbootrabbit.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: simpleOneToManyReceive
 * @Author: liugui
 * @Date: 2019-11-07 19:36
 **/
@Component
@RabbitListener(queues = "simpleOneToMany")
public class simpleOneToManyReceive {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String message) {
        logger.info("simpleOneToMany Receive :{}", message);
    }
}
