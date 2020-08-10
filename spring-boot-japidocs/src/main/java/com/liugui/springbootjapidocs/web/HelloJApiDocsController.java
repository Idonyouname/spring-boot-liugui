package com.liugui.springbootjapidocs.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 * @ClassName: HelloJApiDocsController
 * @Author: liugui
 * @Date: 2020-07-23 11:45
 **/
@RestController
@RequestMapping("/jApiDocs")
public class HelloJApiDocsController {

    /**
     * hi
     * @param name
     * @return ResponseEntity
     */
    @GetMapping("/hi")
    public ResponseEntity hi(String name){
        return new ResponseEntity<>(name,HttpStatus.OK);
    }
}
