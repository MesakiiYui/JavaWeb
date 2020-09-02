package com.mesakiiyui.test.com.mesakiiyui.springdatamysql.JUnitTest.jpa;

import com.SpringdatamysqlApplication;
import com.alibaba.fastjson.JSON;
import com.mesakiiyui.springdatamysql.common.entity.City;
import com.mesakiiyui.springdatamysql.common.repo.CityRepository;
import com.mesakiiyui.springdatamysql.common.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: jintienan
 * @Date: 2020/8/13 15:57
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringdatamysqlApplication.class }) // 开启bean的初始化扫描
public class JpaCommonQueryTest {
    @Autowired
    CityRepository cityRepository;

    @Autowired
    CityService cityService;

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    /**
     * part of city data
     * {"district":"Kabol","id":1,"name":"Kabul","population":1780000},
     * {"district":"Qandahar","id":2,"name":"Qandahar","population":237500},
     * {"district":"Herat","id":3,"name":"Herat","population":186800}
     */
    @Test
    public void testFindAll(){
        List<City> cityList = cityRepository.findAll();
        log.warn(JSON.toJSONString(cityList));
    }

    /**
     * 单要素查询
     */
    @Test
    public void testFindByName(){
        String cityName = "Kabul";
        List<City> cityList = cityRepository.findByName(cityName);
        log.warn(JSON.toJSONString(cityList));
    }

    /**
     * AND
     */
    @Test
    public void testFindByNameAndId(){
        String name = "Kabul";
        Integer id = 1;
        List<City> cityList = cityRepository.findByNameAndId(name, id);
        log.warn(JSON.toJSONString(cityList));
    }

    /**
     * OR
     */
    @Test
    public void testFindByNameOrId(){
        String name = "Kabul";
        Integer id = 2;
        List<City> cityList = cityRepository.findByNameOrId(name, id);
        log.warn(JSON.toJSONString(cityList));
    }

    /**
     * OrderBy pageable
     */
    @Test
    public void testFindByPopulationOrderWithPageable(){
        //PageRequest已过时
        //PageRequest的对象构造函数有多个，page是页数，初始值是0，size是查询结果的条数，后两个参数参考Sort对象的构造方法
        Pageable pageable = PageRequest.of(0,3, Sort.Direction.DESC,"id");
        Page<City> cityPage = cityService.findByPopulationOrderWithPageAble(pageable);
        log.info(JSON.toJSONString(cityPage));
    }

    /**
     * 对于分页查询，测试它的controller
     */
    @Test
    public void whenQuerySuccess() throws Exception{
        String responseString = mockMvc.perform(
                get("http://localhost:8080/City/findPageCityOrderByPopulation")
                        //分页查询参数，第三页，每页15个数据，按照年龄倒序排序
                        .param("size","10")
                        .param("page","3")

                        .contentType(MediaType.APPLICATION_JSON_UTF8) //编码格式为json的utf8
        ).andExpect(status().isOk())  //返回的状态码为200 OK
                .andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
        System.out.println("--------返回的json = " + responseString);
    }

    /**
     * 限制结果数量 ，可以用top和first
     * 先按人口数量从大到小排序，截前10
     */
    @Test
    public void findFirst10ByPopulationGreaterThanOrderByPopulation(){
        Integer population = 4200000;
        // First换成Top效果也一样
        // 相当于select * from city where population > ? order by population  limit 10
        List<City> cityList = cityRepository.findFirst10ByPopulationGreaterThanOrderByPopulationDesc(population);
        System.out.println(JSON.toJSONString(cityList));
    }
}
