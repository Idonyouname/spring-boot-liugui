package com.liugui.springbootscheduled.scheduled;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;

/**
 * @ClassName: ScheduledTask
 * @Author: liugui
 * @Date: 2019-12-20 10:30
 **/
@Component
public class ScheduledTask {

    //  Cron表达式是一个字符串，字符串以5或6个空格隔开，分为6或7个域，每一个域代表一个含义，Cron有如下两种语法格式：
    //（1） Seconds Minutes Hours DayofMonth Month DayofWeek Year
    //（2）Seconds Minutes Hours DayofMonth Month DayofWeek
    //  corn从左到右（用空格隔开）：秒 分 小时 月份中的日期 月份 星期中的日期 年份

    @Scheduled(cron = "0 * 11 * * ?")
    @Async
    public void scheduledTask1(){
        System.out.println("定时任务1");
    }
    //fixedDelay 下次执行时间，fixedDelay等当前任务进行完成后 开始计时（比下面fixedRate 多了 sleep时间 即2秒）
    @Scheduled(initialDelay =  1000 * 10,fixedDelay = 1000 * 5)
    public void scheduledTask2(){
        System.out.println("任务2执行时间："+ LocalTime.now());
        System.out.println("定时任务2");
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务2结束时间："+LocalTime.now());
    }
    //fixedRate  下次执行时间，从任务开始运行时 开始计时。
    @Scheduled(initialDelay =  1000 * 10,fixedRate = 1000 * 5)
    @Async
    public void scheduledTask3(){
        System.out.println("任务3执行时间："+LocalTime.now());
        System.out.println("定时任务3");
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务3结束时间："+LocalTime.now());
    }

}
