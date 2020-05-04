package com.liugui.springbootidempotence.controller;

import com.alibaba.fastjson.JSON;
import com.liugui.springbootidempotence.VO.Msg;
import com.liugui.springbootidempotence.annotation.AutoIdempotent;
import com.liugui.springbootidempotence.constant.Constant;
import com.liugui.springbootidempotence.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: BusinessController
 * @Author: liugui
 * @Date: 2020-05-04 17:47
 **/
@RestController
public class BusinessController {

    @Resource
    private TokenService tokenService;

    @GetMapping("/getToken")
    public String getToken() {
        String token = tokenService.createToken();
        if (StringUtils.isNotEmpty(token)) {
            return JSON.toJSONString(new Msg<>().setData(token).success().setCode("查询成功"));
        }
        return StringUtils.EMPTY;
    }

    @AutoIdempotent
    @PostMapping("/postTest")
    public String testIdempotent(HttpServletRequest request) {
        String token = request.getHeader(Constant.TOKEN_NAME);
        if (StringUtils.isNotEmpty(token)){
            return JSON.toJSONString(new Msg<>().setData(token).success().setCode("执行成功"));
        }
        return StringUtils.EMPTY;
    }


}
