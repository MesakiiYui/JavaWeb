package com.mesakiiyui.springdatamysql.JUnitTest.jpa;

import com.SpringdatamysqlApplication;
import com.mesakiiyui.dm.entity.Student;
import com.mesakiiyui.dm.repo.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Callable;

/**
 * @Author: jintienan
 * @Date: 2021/2/1 14:09
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringdatamysqlApplication.class }) // 开启bean的初始化扫描
public class ThreadJpa {

    private int threadId = 1;
    private int batchSize = 1000;

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void init() throws InterruptedException{
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(100);
        threadPoolTaskExecutor.setMaxPoolSize(100);
        threadPoolTaskExecutor.setKeepAliveSeconds(3000);
        threadPoolTaskExecutor.setQueueCapacity(500);
        threadPoolTaskExecutor.initialize(); // 线程池初始化
        // 开启100个线程
        for(int i = 0; i < 100; i ++){
            Callable callable = new Callable() {
                @Override
                public Object call() throws Exception {
                    insertData();
                    return "";
                }
            };
            threadPoolTaskExecutor.submit(callable);
        }

    }
     public void insertData() throws InterruptedException{
        log.info("-- thread-- " + (threadId++) + " is working");
         // 每个线程产生一千条数据
         for(int i = 0; i < 1000; i ++){
             try{
                 Student student = new Student();
                 student.setName("学生"+i);
                 student.setSex((i % 2) + "");
                 student.setBirth(new java.sql.Date(new java.util.Date().getTime()));
                 student.setDepartment("doctor");
                 student.setAddress("China");
                 student.setLastUptDttm(new java.sql.Date(new java.util.Date().getTime()));
                 student.setCrtDttm(new java.sql.Date(new java.util.Date().getTime()));
                 studentRepository.save(student);
                 studentRepository.flush();
             }catch (Exception e){
                 log.error("发生错误：{}, {}", e.toString(),e.getStackTrace());
             }
         }
     }
}
