package com.liugui.springbootidempotence.interceptor;

import com.alibaba.fastjson.JSON;
import com.liugui.springbootidempotence.annotation.AutoIdempotent;
import com.liugui.springbootidempotence.exception.ServiceException;
import com.liugui.springbootidempotence.service.TokenService;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @ClassName: AutoIdempotentInterceptor
 * @Author: liugui
 * @Date: 2020-05-04 17:32
 **/
@Component
public class AutoIdempotentInterceptor implements HandlerInterceptor {

    @Resource
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //被AutoIdempotent标记的扫描
        AutoIdempotent methodAnnotation = method.getAnnotation(AutoIdempotent.class);
        if (methodAnnotation != null) {
            try {
                return tokenService.checkToken(request);
                // 幂等性校验, 校验通过则放行, 校验失败则抛出异常, 并通过统一异常处理返回友好提示
            }catch (Exception ex){
                throw new ServiceException(ex.getMessage(),101);
            }
        }
        //必须返回true,否则会被拦截一切请求
        return true;
    }

}
