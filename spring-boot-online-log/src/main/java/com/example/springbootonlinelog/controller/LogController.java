package com.example.springbootonlinelog.controller;

import com.example.springbootonlinelog.entity.Log;
import com.example.springbootonlinelog.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统日志(Log)表控制层
 *
 * @author liugui
 * @since 2020-03-11 18:30:03
 */
@RestController
@RequestMapping("log")
public class LogController {
    /**
     * 服务对象
     */
    @Resource(name = "oneLogService")
    private LogService logService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @com.example.springbootonlinelog.aop.Log("查询日志")
    @GetMapping("selectOne")
    public Log selectOne(Long id) {
        return this.logService.queryById(id);
    }



}