package com.mesakiiyui.dm.common.utils.config;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;

/**
 * @Author: jintienan
 * @Date: 2021/2/20 14:25
 */
@Slf4j
@Configuration
@ComponentScan("com.mesakiiyui.dm.common.service")
@PropertySource("classpath:application.properties")
public class SpringELConfig {
    @Value("static inject")
    private String normal;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{T(java.lang.Math).random()*100.0}")
    private BigDecimal randomNumber;

    @Value("#{springELService.anotherValue}")
    private String anotherValue;

    @Value("classpath:springELTest.txt")
    private Resource textFile;

    @Value("http://www.baidu.com")
    private Resource testUrl;

    @Value("${springELConfig.name}")
    private String configName;

    @Autowired
    Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try{
            log.info(normal);
            log.info(osName);
            log.info(randomNumber.toString());
            log.info(anotherValue);
            log.info(IOUtils.toString(textFile.getInputStream(), "utf-8"));
            log.info(IOUtils.toString(testUrl.getInputStream(), "utf-8"));
            log.info(configName);
            log.info(environment.getProperty("springELConfig.age"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
