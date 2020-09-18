package com.example.springbootquartz2.config;

import com.example.springbootquartz2.service.ScheduledTask;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @ClassName: QuartzConfig
 * @Author: liugui
 * @Date: 2020-09-18 10:51
 **/
@Slf4j
@Configuration
public class QuartzConfig {

    /**
     * 方法名：
     * 功能：配置定时任务
     */
    @Bean(name = "jobDetail")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduledTask task){
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        /*
         * 是否并发执行
         * 例如每5s执行一次任务，但是当前任务还没有执行完，就已经过了5s了，
         * 如果此处为true，则下一个任务会执行，如果此处为false，则下一个任务会等待上一个任务执行完后，再开始执行
         */
        jobDetail.setConcurrent(false);
        //设置定时任务的名字
        jobDetail.setName("srd-demo");
        //设置任务的分组，这些属性都可以在数据库中，在多任务的时候使用
        jobDetail.setGroup("srd");

        //为需要执行的实体类对应的对象
        jobDetail.setTargetObject(task);

        /*
         * sayHello为需要执行的方法
         * 通过这几个配置，告诉JobDetailFactoryBean我们需要执行定时执行ScheduleTask类中的sayHello方法
         */
        jobDetail.setTargetMethod("sayHello");
        log.info("jobDetail 初始化成功！");
        return jobDetail;
    }

    /**
     * 方法名：
     * 功能：配置定时任务的触发器，也就是什么时候触发执行定时任务
     */
    @Bean(name = "jobTrigger")
    public CronTriggerFactoryBean cronTriggerFactoryBean(MethodInvokingJobDetailFactoryBean jobDetail){
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(jobDetail.getObject());
        //初始化的cron表达式(每天上午10:15触发)
        trigger.setCronExpression("0 15 10 * * ?");
        //trigger的name
        trigger.setName("srd-demo");
        log.info("jobTrigger 初始化成功！");
        return trigger;
    }

    /**
     * 方法名：
     * 功能：定义quartz调度工厂
     */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactoryBean(Trigger trigger){
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        //用于quartz集群，QuartzScheduler启动时更新已存在的job
        factoryBean.setOverwriteExistingJobs(true);
        //延时启动，应用启动1秒后
        factoryBean.setStartupDelay(1);
        //注册触发器
        factoryBean.setTriggers(trigger);
        log.info("scheduler 初始化成功！");
        return factoryBean;
    }
}
