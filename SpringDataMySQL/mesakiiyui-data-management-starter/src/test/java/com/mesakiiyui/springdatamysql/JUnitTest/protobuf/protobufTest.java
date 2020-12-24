package com.mesakiiyui.springdatamysql.JUnitTest.protobuf;

import com.SpringdatamysqlApplication;
import com.alibaba.fastjson.JSON;
import com.mesakiiyui.springdatamysql.common.service.protobuf.AddressBookProtos;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: jintienan
 * @Date: 2020/12/8 15:42
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringdatamysqlApplication.class }) // 开启bean的初始化扫描
public class protobufTest {

    @Test
    public void testFirstProtobufDemo(){
        AddressBookProtos.Person.Builder builder = AddressBookProtos.Person.newBuilder();
        builder.setId(1);
        builder.setEmail("123.gmail.com");
        builder.setName("wangwang");
        AddressBookProtos.Person person = builder.build();
        log.info("get person :" + JSON.toJSONString(person));
        for(byte b : person.toByteArray()){
            log.info(JSON.toJSONString(b));
        }
        log.info("get person byteString:" + person.toByteString());
        //模拟接收Byte[]，反序列化成Person类
        byte[] byteArray =person.toByteArray();
        System.out.println("after :" +JSON.toJSONString(byteArray));



    }
}
