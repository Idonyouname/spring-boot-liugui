package com.liugui.springbootcache.controller;

import com.alibaba.fastjson.JSON;
import com.liugui.springbootcache.model.UserDo;
import com.liugui.springbootcache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private UserService service;

    @GetMapping("/findUserByMap")
    public String findUserByMap(String userName){
        Map<String,Object> map = new HashMap<>();
        if (null != userName){
            map.put("userName",userName);
        }
        List<UserDo> userDoList = service.selectListByMap(map);
        return JSON.toJSONString(userDoList);
    }

    @GetMapping("/findUserByMultiCondition")
    public String findUserByMultiCondition(String conditionStr){
        return JSON.toJSONString(service.selectByStr(conditionStr));
    }

    @PostMapping
    public String addUser(UserDo userDo){
        try {
            return service.save(userDo) > 0 ? "执行成功" : "操作失败";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "操作失败";
    }

    @PutMapping
    public String updateUser(UserDo userDo){
        try {
            return service.update(userDo) > 0 ? "执行成功" :"操作失败";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "操作失败";
    }

}
