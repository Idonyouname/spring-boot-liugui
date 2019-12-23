package com.liugui.springbootgradleyml.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Author: liugui
 * @Date: 2019-12-23 16:42
 **/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String helloGradle(){
        return "yml配置 初体验";
    }

}
