package com.liugui.springbootquartz.config;

import com.liugui.springbootquartz.task.OneTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: QuartzConfig
 * @Author: liugui
 * @Date: 2019-12-20 14:27
 **/
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetailOne(){
        return JobBuilder.newJob(OneTask.class).withIdentity("OneTask").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger1() {
        //5秒执行一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever();

        //传入schedule 对象 确立定时规则
        //也可以构造cron 表达式 CronScheduleBuilder.cronSchedule("*/5 * * * * ?")
        return TriggerBuilder.newTrigger().forJob(jobDetailOne())
                .withIdentity("OneTask")
                .withSchedule(scheduleBuilder)
                .build();
    }



}
