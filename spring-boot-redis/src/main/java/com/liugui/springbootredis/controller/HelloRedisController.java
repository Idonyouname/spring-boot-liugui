package com.liugui.springbootredis.controller;

import com.liugui.commonutils.utils.RedisUtil;
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
    public String redisSet(@PathVariable String name) {
        redisUtil.set("name", name);
        return "ok";
    }

    @RequestMapping("/redisGet/{key}")
    public String redisGet(@PathVariable String key) {
        return redisUtil.get(key).toString();
    }

    @RequestMapping("/redisKeyPastDuePush/{value}")
    public String redisKeyPastDuePush(@PathVariable String value) {
        String key = "Phone:13022221111";
        redisUtil.set(key, value, 3L);
        return "设置3秒过期键值完成 - 未序列化key";
    }

}
