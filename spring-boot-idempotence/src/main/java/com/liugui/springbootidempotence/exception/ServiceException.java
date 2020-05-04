package com.liugui.springbootidempotence.exception;

import lombok.Data;

/**
 * @ClassName: ServiceException
 * @Author: liugui
 * @Date: 2020-05-04 17:15
 **/
public class ServiceException extends Exception {
    private String message;
    private int stateCode;

    public ServiceException(String message, int stateCode) {
        this.message = message;
        this.stateCode = stateCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }
}
