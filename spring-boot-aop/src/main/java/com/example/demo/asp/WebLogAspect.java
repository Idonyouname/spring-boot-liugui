package com.example.demo.asp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description
 * @Auther liugui
 * @Create 2019/8/29 18:56
 */
@Aspect
@Component
@Order(-5)
public class WebLogAspect {

	private Logger logger = LogManager.getLogger(WebLogAspect.class);

	/**
	 * 定义切入点，切入点为com.amdox.serviceapi下的所有函数
	 */
	@Pointcut("execution(public * com.example.demo..*.*(..))")
	public void webLog(){}

	/**
	 * 前置通知：在连接点之前执行的通知
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.info("请求URL : " + request.getRequestURL().toString());
		logger.info("请求方法HTTP_METHOD : " + request.getMethod());
		logger.info("请求IP : " + request.getRemoteAddr());
		logger.info("请求类名CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(returning = "ret",pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		logger.info("返回内容RESPONSE : " + ret);
	}
}
