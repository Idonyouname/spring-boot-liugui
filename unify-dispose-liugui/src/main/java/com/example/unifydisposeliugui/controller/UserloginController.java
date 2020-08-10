package com.example.unifydisposeliugui.controller;


import com.example.unifydisposeliugui.service.UserloginService;
import com.example.unifydisposeliugui.vo.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lg
 * @since 2020-08-10
 */
@RestController
@RequestMapping("/userlogin")
public class UserloginController {

    @Resource
    private UserloginService userloginService;

    @GetMapping("/list")
    public R list(){

//        int i = 1/0; 未知错误

        return R.ok().data("list",userloginService.list()).message("获取数据成功");
    }

}

