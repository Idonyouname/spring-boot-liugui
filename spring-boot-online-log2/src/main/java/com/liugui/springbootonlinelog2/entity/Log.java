package com.liugui.springbootonlinelog2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: Log
 * @Author: liugui
 * @Date: 2020-07-21 18:04
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_log")
public class Log {
    private String id;
    private String method;
    private Date createTime;
    private String ip;
    private String brownerNo;
    private String osNo;
    /**
     * 请求参数
     */
    private String params;
    /**
     * 操作模块
     */
    private String module;
    /**
     * 操作详情
     */
    private String operationDesc;
    /**
     * 请求返回结果
     */
    private String result;
    /**
     * 请求返回状态
     */
    private String resultStatus;
}
