package com.mesakiiyui.springdatamysql.JUnitTest;

import com.SpringdatamysqlApplication;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mesakiiyui.dm.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: jintienan
 * @Date: 2021/2/23 16:26
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringdatamysqlApplication.class }) // 开启bean的初始化扫描
public class JSONParserTest {

    @Test
    public void testJSONParser(){
        // {"name":"ack", "name2":"aaaa"}
        String resultMsg = "{\"name\":\"ack\", \"name2\":\"aaaa\"}";
        Student student = JSONObject.parseObject(resultMsg, Student.class);
        log.info("student"+ JSON.toJSONString(student));
    }

}
