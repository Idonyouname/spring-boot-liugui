package com.liugui.springbooth2database;

import com.liugui.springbooth2database.mapper.UserMapper;
import com.liugui.springbooth2database.model.UserDo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class SpringBootH2databaseApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private UserMapper userMapper;

    @Test
    public void selectUserById(){
        UserDo userDo = userMapper.selectById(1);
        System.out.println(userDo);
    }

}
