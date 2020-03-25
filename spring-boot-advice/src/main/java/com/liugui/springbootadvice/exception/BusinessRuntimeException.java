package com.liugui.springbootadvice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义业务异常类
 * @ClassName: BusinessRuntimeException
 * @Author: liugui
 * @Date: 2020-03-25 11:01
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessRuntimeException extends RuntimeException {
    //执行状态 1表示成功 2表示失败
    private String state;

    //返回的提示语
    private String code;


}
