package com.liugui.springbootredis;

import com.liugui.commonutils.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootRedisApplicationTests {

    @Test
    void contextLoads() {
       redisUtil.getKeys("*");
    }

    @Resource
    private RedisUtil redisUtil;

}
