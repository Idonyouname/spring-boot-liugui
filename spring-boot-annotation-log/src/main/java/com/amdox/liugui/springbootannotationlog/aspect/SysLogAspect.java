package com.amdox.liugui.springbootannotationlog.aspect;

import com.alibaba.fastjson.JSON;
import com.amdox.liugui.springbootannotationlog.utils.LoggerCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * @ClassName: SysLogAspect
 * @Author: liugui
 * @Date: 2019-11-26 15:53
 **/
@Aspect
@Component
public class SysLogAspect {


    /**自定义 @SysLog 注解为切点*/
    @Pointcut("@annotation(com.amdox.liugui.springbootannotationlog.annotation.SysLog)")
    public void log() { }

    /**
     * 环绕增强
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "log()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        // 获取执行方法的类的名称（包名加类名）
        String className = joinPoint.getTarget().getClass().getName();
        // 获取实例和方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        //从缓存中获取日志实例
        Logger log = LoggerCache.getLoggerByClassName(className);

        Object proceed = joinPoint.proceed();
        // 记录日志
        log.info("Method\t===》\t{}",className + "." + method.getName() + "() 执行");
        Object[] args = joinPoint.getArgs();
        log.info("Params\t===》\t{}", JSON.toJSONString(args));
        // 执行方法获取返回值

        // 记录日志
        log.info("Returns\t===》\t{}",JSON.toJSONString(proceed));
        //耗时
        log.info("执行耗时\t===》\t{} ", System.currentTimeMillis() - startTime);
        // 返回
        return proceed;
    }
}
