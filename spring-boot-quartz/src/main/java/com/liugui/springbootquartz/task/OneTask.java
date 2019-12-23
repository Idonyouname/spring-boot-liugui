package com.liugui.springbootquartz.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;

/**
 * @ClassName: OneTask
 * @Author: liugui
 * @Date: 2019-12-20 14:25
 **/
public class OneTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("OneTask FireTime:" + sdf.format(context.getFireTime()));
    }
}
