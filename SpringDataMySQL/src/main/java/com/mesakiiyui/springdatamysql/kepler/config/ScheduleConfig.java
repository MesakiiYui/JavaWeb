package com.mesakiiyui.springdatamysql.kepler.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * @Author: jintienan
 * @Date: 2020/8/10 16:53
 */
@Slf4j
@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.setScheduler(taskExecutor());
    }

//    @Bean(destroyMethod="(shutdown")
//    public Executor taskExecutor() {
//        return Executors.newScheduledThreadPool(10); //指定线程池大小
//    }

}
