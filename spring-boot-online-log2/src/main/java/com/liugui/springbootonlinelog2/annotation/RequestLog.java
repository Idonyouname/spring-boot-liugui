package com.liugui.springbootonlinelog2.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestLog {
    /**
     * 请求模块名
     * @return
     */
    public String module() default "";

    /**
     * 接口详情描述
     * @return
     */
    public String operationDesc() default "";
}
