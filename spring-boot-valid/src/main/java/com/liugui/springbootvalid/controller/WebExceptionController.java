package com.liugui.springbootvalid.controller;

import com.alibaba.fastjson.JSON;
import com.liugui.springbootvalid.model.Msg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

/**
 * @Description 全局异常处理
 * @Auther liugui
 * @Create 2019/8/7 16:59
 */
@RestControllerAdvice
public class WebExceptionController {
    private static Logger logger = LogManager.getLogger(WebExceptionController.class);

    /**
     * 参数效验异常处理
     */
    @ExceptionHandler(value = BindException.class)
    public String handleBindException(BindException e){
        logger.error("参数校验异常",e);
        if (null != e.getBindingResult().getFieldError()
                && !ObjectUtils.isEmpty(e.getBindingResult().getFieldError().getDefaultMessage())) {
            String message = e.getBindingResult().getFieldError().getDefaultMessage();
            return JSON.toJSONString(new Msg<>().fail().setCode(message));
        }
        return JSON.toJSONString(new Msg<>().fail().setCode("参数校验异常"));
    }

    /**
     *
     * 单参数 @NotNull @NotBlank @NotEmpty 效验异常处理
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public String HandleConstraintViolationException(ConstraintViolationException e){
        logger.error("参数校验异常",e);
        if (null != e.getConstraintViolations() && !ObjectUtils.isEmpty(e.getConstraintViolations())) {
            String message = e.getMessage().substring(e.getMessage().indexOf(":")+1,e.getMessage().length());
            return JSON.toJSONString(new Msg<>().fail().setCode(message));
        }
        return JSON.toJSONString(new Msg<>().fail().setCode("参数校验异常"));
    }

    /**
     * 参数效验异常处理
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String MyMethodArgumentNotValidException(MethodArgumentNotValidException e){
        logger.error("参数解析失败", e);
        if (null != e.getBindingResult().getFieldError()
                && !ObjectUtils.isEmpty(e.getBindingResult().getFieldError().getDefaultMessage())) {
            return JSON.toJSONString(new Msg().setCode(e.getBindingResult().getFieldError()
                    .getDefaultMessage()).fail());
        }
        return JSON.toJSONString(new Msg().setCode("参数校验异常").fail());
    }

    /**
     * Assert  参数为空异常拦截
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public String httpMediaTypeNotSupportedException(Exception e) {
        logger.error("参数错误异常", e);
        return JSON.toJSONString(new Msg().setCode(e.getMessage()).fail());
    }

}

