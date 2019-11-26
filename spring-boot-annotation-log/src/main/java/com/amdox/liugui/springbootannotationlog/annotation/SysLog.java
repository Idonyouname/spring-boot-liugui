package com.amdox.liugui.springbootannotationlog.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: SysLog
 * @Author: liugui
 * @Date: 2019-11-26 15:53
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    /**
     * 日志描述信息
     *
     * @return
     */
    String description() default "";
}
