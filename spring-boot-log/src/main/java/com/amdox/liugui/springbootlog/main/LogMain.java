package com.amdox.liugui.springbootlog.main;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: LogController
 * @Author: liugui
 * @Date: 2019-11-27 10:56
 **/
@Slf4j
public class LogMain {

    public static void main(String[] args) {

        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");

        log.info("logging begin...");
        try {
            throw new Exception("抛个异常先");
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        log.info("logging end...");
    }
}
