package com.liugui.springbootadvice.exception;

import com.liugui.springbootadvice.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * 自定义全局异常处理类
 * @ClassName: GlobalExceptionHandler
 * @Author: liugui
 * @Date: 2020-03-25 11:08
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 搭配 @Valid 使用
     * 参数效验异常处理
     */
    @ExceptionHandler(value = BindException.class)
    public Response handleBindException(BindException e){
        log.error("参数校验异常",e);
        if (null != e.getBindingResult().getFieldError()
                && !ObjectUtils.isEmpty(e.getBindingResult().getFieldError().getDefaultMessage())) {
            String message = e.getBindingResult().getFieldError().getDefaultMessage();
            return new Response<>().fail().code(message);
        }
        return new Response<>().fail().code("参数校验异常");
    }

    /**
     * 搭配 @Valid 使用
     * 参数效验异常处理
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response MyMethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error("参数解析失败", e);
        if (null != e.getBindingResult().getFieldError()
                && !ObjectUtils.isEmpty(e.getBindingResult().getFieldError().getDefaultMessage())) {
            return new Response().code(e.getBindingResult().getFieldError()
                    .getDefaultMessage()).fail();
        }
        return new Response().code("参数校验异常").fail();
    }

    /**
     * 搭配 单参数 @NotNull @NotBlank @NotEmpty 效验异常处理
     * 参数效验异常处理
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Response HandleConstraintViolationException(ConstraintViolationException e){
        log.error("参数校验异常",e);
        if (null != e.getConstraintViolations() && !org.springframework.util.ObjectUtils.isEmpty(e.getConstraintViolations())) {
            String message = e.getMessage().substring(e.getMessage().indexOf(":")+1,e.getMessage().length());
            return new Response<>().fail().code(message);
        }
        return new Response<>().fail().code("参数校验异常");
    }

    /**
     * 处理自定义的业务异常
     */
    @ExceptionHandler(value = BusinessRuntimeException.class)
    public Response bizExceptionHandler(BusinessRuntimeException e){
        log.error("业务异常：{}",e.getCode());
        return new Response().fail().code(e.getCode());
    }

    /**
     * 处理空指针的异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    public Response nullExceptionHandler(NullPointerException e){
        log.error("空指针异常:",e);
        return new Response().fail().code(e.getMessage());
    }

    /**
     * 405 - Method Not Allowed
     *
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("不支持当前请求方法", e);
        return new Response().fail().code("不支持当前请求方法");
    }

    /**
     * 415 - Unsupported Media Type
     *
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Response handleHttpMediaTypeNotSupportedException(Exception e) {
        log.error("不支持当前媒体类型", e);
        return new Response().fail().code("不支持当前媒体类型");
    }

    /**
     * 500
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response exceptionHandler( Exception e){
        log.error("未知异常:",e);
        return new Response().fail().code(e.getMessage());
    }

}
