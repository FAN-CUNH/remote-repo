package com.fch.config;

import com.fch.task.CleanImgTask;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.Resource;

/**
 * @packageName com.fch.config
 * @ClassName QuartzConfig
 * @Description 定时器配置类
 * @Author Fan-CUNH
 * @Date 2023/7/12 18:49
 * @Version 1.0
 */
@ComponentScan(basePackages = "com.fch.task")
public class QuartzConfig {
    @Resource
    private CleanImgTask cleanImgTask;

    /**
     * 注册一个任务，即具体要执行的业务逻辑
     *
     * @return 任务
     * @throws Exception 异常
     */
    @Bean
    public JobDetail jobDetail() throws Exception {
        MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
        // 注入目标对象
        methodInvokingJobDetailFactoryBean.setTargetObject(cleanImgTask);
        // 注入目标方法
        methodInvokingJobDetailFactoryBean.setTargetMethod("cleanImg");
        methodInvokingJobDetailFactoryBean.afterPropertiesSet();
        return methodInvokingJobDetailFactoryBean.getObject();
    }

    /**
     * 注册一个触发器，指定任务触发的时间
     *
     * @return 触发器
     * @throws Exception 异常
     */
    @Bean
    public CronTrigger cronTrigger() throws Exception {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        // 注入 JobDetail
        cronTriggerFactoryBean.setJobDetail(jobDetail());
        cronTriggerFactoryBean.setCronExpression("0/20 * * * * ?");
        cronTriggerFactoryBean.afterPropertiesSet();
        return cronTriggerFactoryBean.getObject();
    }

    @Bean
    public Scheduler scheduler() throws Exception {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        // 注入多个触发器
        schedulerFactoryBean.setTriggers(cronTrigger());
        schedulerFactoryBean.afterPropertiesSet();
        // 启动定时任务调度器
        schedulerFactoryBean.start();
        return schedulerFactoryBean.getObject();
    }
}
