package com.amdox.liugui.springbootannotationlog.controller;

import com.alibaba.fastjson.JSONObject;
import com.amdox.liugui.springbootannotationlog.annotation.SysLog;
import com.amdox.liugui.springbootannotationlog.utils.LoggerCache;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName: LogTestController
 * @Author: liugui
 * @Date: 2019-11-26 16:18
 **/
@RestController
public class LogTestController {

    @GetMapping("/now")
    public String now(){
        // 从缓存中获取日志
        Logger logger = LoggerCache.getLoggerByClassName(this.getClass().getName());
        logger.info("自定义日志 ==》 日志内容。。。");
        return JSONObject.toJSONString(new Date());
    }

    @GetMapping("/hello")
    @SysLog()
    public String hello(String name){
        return "Hello, " + name;
    }
}
