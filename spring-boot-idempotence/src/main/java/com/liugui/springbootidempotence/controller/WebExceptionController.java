package com.liugui.springbootidempotence.controller;

import com.liugui.springbootidempotence.VO.Msg;
import com.liugui.springbootidempotence.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: WebExceptionController
 * @Author: liugui
 * @Date: 2020-05-04 18:08
 **/
@RestControllerAdvice
public class WebExceptionController {
    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public Msg serviceExceptionHandler(ServiceException ex) {
        return new Msg().setNum(ex.getStateCode()).setCode(ex.getMessage()).fail();
    }
}
