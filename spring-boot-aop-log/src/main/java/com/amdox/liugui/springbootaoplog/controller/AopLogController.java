package com.amdox.liugui.springbootaoplog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: aopLogController
 * @Author: liugui
 * @Date: 2019-11-25 17:56
 **/
@RestController
public class AopLogController {

    @RequestMapping("/getLog")
    public String getLog(){
        return "Hello Aop Log";
    }

    @RequestMapping("/doError")
    public Object error() {
        return 1 / 0;
    }

}
