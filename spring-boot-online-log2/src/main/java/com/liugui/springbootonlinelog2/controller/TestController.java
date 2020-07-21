package com.liugui.springbootonlinelog2.controller;

import com.alibaba.fastjson.JSON;
import com.liugui.springbootonlinelog2.annotation.RequestLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName: TestController
 * @Author: liugui
 * @Date: 2020-07-21 17:45
 **/
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 测试使用
     * @return 测试
     */
    @RequestLog(module = "requestTest",operationDesc = "测试使用")
    @RequestMapping(value = "/requestTest",method = RequestMethod.GET)
    public String requestTest(){
        String result = null;
        try {
            int num = 1 / 0;
            result = "请求成功";
        }catch (Exception e){
            log.warn("操作失败");
            result = "请检查请求方式";
            return JSON.toJSONString(new ResponseEntity<>(result,
                    HttpStatus.UNSUPPORTED_MEDIA_TYPE));
        }
        return JSON.toJSONString(new ResponseEntity<>(result,
                HttpStatus.OK));
    }

}
