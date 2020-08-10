package com.example.unifydisposeliugui.vo;

import lombok.Getter;

/**
 * 统一结果返回
 */
@Getter
public enum ResultCodeEnum{

    SUCCESS(true,20000,"成功"),
    UNKNOWN_ERROR(false,20001,"未知错误"),
    PARAM_ERROR(false,20002,"参数错误"),
    NULL_POINTER(false,20003,"空指针异常"),
    HTTP_CLIENT_ERROR(false,404,"请求路径不存在"),
    NO_FILE_CONTENT(false, 30001, "文件内容为空"),
    ;

    // 响应是否成功
    private Boolean success;
    // 响应状态码
    private Integer code;
    // 响应信息
    private String message;

    ResultCodeEnum(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}