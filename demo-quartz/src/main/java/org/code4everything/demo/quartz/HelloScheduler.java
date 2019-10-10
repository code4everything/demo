package org.code4everything.demo.quartz;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author pantao
 * @since 2019/10/9
 */
public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {
        // 创建一个JobDetail实例，并与任务绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob", "hello").build();
        // 创建一个Trigger实例，定义任务执行时机
        // @formatter:off
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("helloTrigger", "hello")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                // .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                // 自定义任务数据，Job可以再Context中通过JobDataMap拿到
                .usingJobData("key","value")
                // 设置截止时间
                .endAt(new Date(System.currentTimeMillis() + 10_000))
                // 设置立即启动
                .startNow().build();
        // @formatter:on
        // 创建一个任务调度器
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        Console.log("current time: {}", DateUtil.formatDateTime(new Date()));
        // 启动并执行任务
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
