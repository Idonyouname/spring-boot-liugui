package com.amdox.liugui.springbootannotationlog.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


/**
 * @ClassName: SysLogAspect
 * @Author: liugui
 * @Date: 2019-11-26 15:53
 **/
@Aspect
@Component
//@Profile("dev") 用 @Profile 注解可以指定类或方法在特定的 Profile 环境生效。
public class SysLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(SysLogAspect.class);

    /**
     * 自定义 @SysLog 注解为切点
     */
    @Pointcut("@annotation(com.amdox.liugui.springbootannotationlog.annotation.SysLog)")
    public void log() { }

    /**
     * 前置增强
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 打印请求相关参数
        logger.info("========================================== Start ==========================================");
        // 打印请求 url
        logger.info("URL\t===》\t{}", request.getRequestURL().toString());
        // 打印 Http method
        logger.info("HTTP Method\t===》\t{}", request.getMethod());
        // 打印请求的 IP
        logger.info("IP\t===》\t{}", request.getRemoteAddr());
    }

    /**
     * 环绕增强
     */
    @Around(value = "log()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        // 获取执行方法的类的名称（包名加类名）
        String className = joinPoint.getTarget().getClass().getName();
        // 获取实例和方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object proceed = joinPoint.proceed();
        //方法名
        logger.info("Method\t===》\t{}", className + "." + method.getName() + "() 执行");
        Object[] args = joinPoint.getArgs();
        // 入参
        logger.info("Params\t===》\t{}", JSON.toJSONString(args));
        // 执行方法获取返回值
        logger.info("Returns\t===》\t{}", JSON.toJSONString(proceed));
        // 耗时
        logger.info("执行耗时\t===》\t{} ", System.currentTimeMillis() - startTime);
        return proceed;
    }

    /**
     * 后置增强
     */
    @After("log()")
    public void doAfter() {
        logger.info("=========================================== End ===========================================");
    }

}
