package com.mesakiiyui.springdatamysql.kepler;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Author: jintienan
 * @Date: 2020/8/10 16:15
 */
@Slf4j
@Configuration
public class DataSchedule {

    @SneakyThrows
    @Async
    @Scheduled(cron = "0/5 * * * * ?")
    public void syncData(){
        log.info("同步测试，立即开始！");
    }

}
