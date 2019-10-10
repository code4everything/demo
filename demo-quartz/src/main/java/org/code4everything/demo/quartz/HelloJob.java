package org.code4everything.demo.quartz;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;

/**
 * @author pantao
 * @since 2019/10/9
 */
@Data
public class HelloJob implements Job {

    /**
     * 在类中定义与JobDataMap的Key同名的并且类型与Value一致的属性，quartz会帮我们自动注入
     */
    private String key;

    @Override
    public void execute(JobExecutionContext context) {
        // 任务：在这里编写具体的业务逻辑，通过content上下文可以获取上层信息
        Console.log("{} hello quartz", DateUtil.formatDateTime(new Date()));
        Console.log("{}, {}", context.getJobDetail().getKey(), context.getTrigger().getKey());
        Console.log(JSON.toJSONString(context.getTrigger().getJobDataMap()));
        // 通过getter和setter自动注入
        Console.log("key: {}", key);
        Console.log();
    }
}
