package com.liugui.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.liugui.springbootmybatis.mapper.UserMapper;
import com.liugui.springbootmybatis.model.UserDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;

/**
 * @ClassName: UserController
 * @Author: liugui
 * @Date: 2019-11-27 17:09
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/findUserByMap")
    public String findUserByMap(String userName){
        Map<String,Object> map = new HashMap<>();
        if (null != userName){
            map.put("userName",userName);
        }
        List<UserDo> userDoList = userMapper.selectListByMap(map);
        return JSON.toJSONString(userDoList);
    }

    @GetMapping("/findUserByMultiCondition")
    public String findUserByMultiCondition(String conditionStr){
        return JSON.toJSONString(userMapper.selectByStr(conditionStr));
    }

}
