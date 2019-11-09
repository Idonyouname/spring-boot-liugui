package com.example.springbootrabbit.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: SimpleReceive
 * @Author: liugui
 * @Date: 2019-11-07 19:32
 **/
@Component
@RabbitListener(queues = "simple")
public class SimpleReceive {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String message) {
        logger.info("Receive :{}", message);
    }

}
