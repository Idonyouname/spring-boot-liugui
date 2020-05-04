package com.liugui.springbootidempotence.service.impl;

import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.util.RandomUtil;
import com.liugui.springbootidempotence.constant.Constant;
import com.liugui.springbootidempotence.exception.ServiceException;
import com.liugui.springbootidempotence.service.TokenService;
import com.liugui.springbootidempotence.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

/**
 * @ClassName: TokenServiceImpl
 * @Author: liugui
 * @Date: 2020-05-04 15:05
 **/
@Slf4j
@Service
public class TokenServiceImpl implements TokenService {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public String createToken() {
        String str = RandomUtil.randomUUID();
        StrBuilder token = new StrBuilder();
        try {
            token.append(Constant.TOKEN_PREFIX).append(str);
            redisUtil.set(Constant.TOKEN_NAME, token.toString(),10000L);
            boolean notEmpty = StringUtils.isNotEmpty(token.toString());
            if (notEmpty) {
                return token.toString();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean checkToken(HttpServletRequest request) throws Exception {
        //打印一下 header
        printHeader(request);
        String token = request.getHeader(Constant.TOKEN_NAME);
        log.warn("token:" + token);
        if(StringUtils.isBlank(token)) {// header中不存在token
            token = request.getParameter(Constant.TOKEN_NAME);
            log.warn("token:" + token);
            if(StringUtils.isBlank(token)) {// parameter中也不存在token
                throw new ServiceException("无效token", 100);
            }
        }
        if(!redisUtil.exists(token)) {
            throw new ServiceException("重复性操作", 200);
        }

        boolean flag =  redisUtil.delete(token);
        if(!flag){
            throw new ServiceException("重复性操作", 200);
        }
        return true;
    }

    private void printHeader(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                log.warn("headerName:" + name);
                Enumeration<String> values = request.getHeaders(name);
                while (values.hasMoreElements()) {
                    String value = values.nextElement();
                    log.warn("headerValue:" + value);
                }
            }
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((x,y) ->  log.warn("key:" + x + "\tvalue:" + y[0]));
    }
}
