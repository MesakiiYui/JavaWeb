package com.mesakiiyui.dm.utils;

import com.SpringdatamysqlApplication;
import com.mesakiiyui.dm.entity.StaticPeople;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: jintienan
 * @Date: 2021/5/31 13:45
 */
@Slf4j
@Profile("dev") // 配置环境
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringdatamysqlApplication.class})
public class YamlTest {

    @Value("${people.name}")
    private String localName;

    @Test
    public void testReadYamlFile(){
        log.info(StaticPeople.name);
        log.info(StaticPeople.age);
        log.info(StaticPeople.education);
        log.info(StaticPeople.sex);
        log.info(localName);
    }
}
