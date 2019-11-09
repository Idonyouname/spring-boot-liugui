package com.example.springbootrabbit.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: SimpleSend
 * @Author: liugui
 * @Date: 2019-11-07 19:31
 **/
@Component
public class SimpleSend {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String message = "Hello Spring Boot " + simpleDateFormat.format(new Date());
        amqpTemplate.convertAndSend("simple", message);
        amqpTemplate.convertAndSend("simpleOneToMany", message);
        logger.info("消息推送成功！");
    }

    public void massSend() {
        String message = "Hello RabbitMQ";
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("simple", message + "simple:" + i);
            amqpTemplate.convertAndSend("simpleOneToMany", message + "simpleOneToMany:"  + i);
        }
        logger.info("消息推送成功！");
    }

}
