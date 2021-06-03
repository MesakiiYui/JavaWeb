package com.mesakiiyui.dm.mybatis;

import com.alibaba.fastjson.JSON;
import com.mesakiiyui.dm.entity.City;
import com.mesakiiyui.dm.mapper.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * https://blog.didispace.com/spring-boot-learning-2x/
 * @Author: jintienan
 * @Date: 2021/6/3 16:33
 */
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class CityMapperTest {

    @Resource
    private CityMapper cityMapper;

    @Test
    public void testQuery(){
        City city = cityMapper.findById(2);
        log.info(JSON.toJSONString(city));
    }

    @Test
    public void testQuery2(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "Kabul");
        City city =  cityMapper.findByIdName(map);
        log.info(JSON.toJSONString(city));
    }
}
