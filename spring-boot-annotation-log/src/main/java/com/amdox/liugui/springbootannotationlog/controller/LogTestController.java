package com.amdox.liugui.springbootannotationlog.controller;

import com.amdox.liugui.springbootannotationlog.annotation.SysLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: LogTestController
 * @Author: liugui
 * @Date: 2019-11-26 16:18
 **/
@RestController
public class LogTestController {

    @GetMapping("/hello")
    @SysLog()
    public String hello(String name){
        return "Hello, " + name;
    }
}
