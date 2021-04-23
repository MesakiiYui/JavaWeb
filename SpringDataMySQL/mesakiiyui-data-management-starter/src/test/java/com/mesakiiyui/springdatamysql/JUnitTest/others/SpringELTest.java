package com.mesakiiyui.springdatamysql.JUnitTest.others;

import com.SpringdatamysqlApplication;
import com.mesakiiyui.dm.common.utils.config.SpringELConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: jintienan
 * @Date: 2021/2/20 15:09
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringdatamysqlApplication.class }) // 开启bean的初始化扫描
public class SpringELTest {

    @Autowired
    SpringELConfig springELConfig;

    @Test
    public void getStaticInfo(){
        springELConfig.outputResource();
    }
}
