package com.liugui.springbootadvice.controller;

import com.liugui.springbootadvice.common.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName: ExceptionTestController
 * @Author: liugui
 * @Date: 2020-03-25 11:25
 **/
@RestController
@RequestMapping("/advice")
@Validated //需要此注解来使@NotBlank生效
public class ExceptionTestController {

    /**
     * 测试notBlank的异常是否被拦截 且能否获取自定义异常信息
     * 其他相关异常可以自行添加代码测试
     */
    @GetMapping("/notBlankTest")
    public Response returnException(@NotBlank(message = "name必填") String name){
        return new Response().code(name).success();
    }


}
