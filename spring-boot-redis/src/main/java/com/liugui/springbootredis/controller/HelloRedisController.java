package com.liugui.springbootredis.controller;

import com.liugui.springbootredis.utils.RedisUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: HelloRedisController
 * @Author: liugui
 * @Date: 2019-12-27 09:35
 **/
@RestController
public class HelloRedisController {

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/redisSet/{name}")
    public String redisSet(@PathVariable String name){
        redisUtil.set("name", name);
        return "ok";
    }

    @RequestMapping("/redisGet/{key}")
    public String redisGet(@PathVariable String key){
        return redisUtil.get(key).toString();
    }

}
