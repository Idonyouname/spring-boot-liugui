package com.amdox.liugui.springbootannotationlog.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * @ClassName: LoggerCache
 * @Author: liugui
 * @Date: 2019-11-26 15:52
 **/
public class LoggerCache {

    /**
     * 日志实例记录在内存中
     */
    private static HashMap<String, Logger> loggerMap = new HashMap<>();

    /**
     * 根据类名获取缓存的日志实例
     * @param className 包名加类名 this.getClass().getName();
     * @return
     */
    public static Logger getLoggerByClassName(String className) {
        // 从静态map中获取日志实例
        Logger logger = loggerMap.get(className);
        // 如果没取到
        if (logger == null) {
            // 创建一个日志实例
            logger = LoggerFactory.getLogger(className);
            // 加入到静态map中
            loggerMap.put(className, logger);
        }
        // 返回
        return logger;
    }
}
