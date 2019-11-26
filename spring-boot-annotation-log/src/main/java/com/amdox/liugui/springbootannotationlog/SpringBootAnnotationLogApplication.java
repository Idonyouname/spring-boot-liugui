package com.amdox.liugui.springbootannotationlog;

import com.alibaba.fastjson.JSONObject;
import com.amdox.liugui.springbootannotationlog.annotation.SysLog;
import com.amdox.liugui.springbootannotationlog.utils.LoggerCache;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@SpringBootApplication
public class SpringBootAnnotationLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAnnotationLogApplication.class, args);
    }

    @RequestMapping("/getLog")
    public String getLog(){
        return "annotation log";
    }


}
