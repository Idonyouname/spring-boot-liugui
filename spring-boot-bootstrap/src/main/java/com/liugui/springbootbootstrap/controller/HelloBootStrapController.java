package com.liugui.springbootbootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: HelloBootStrap
 * @Author: liugui
 * @Date: 2019-12-28 10:59
 **/
@Controller
public class HelloBootStrapController {

    @RequestMapping("/hello")
    public String hello(){
        return "helloBootstrap";
    }

}
