package com.mesakiiyui.dm.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: jintienan
 * @Date: 2021/5/31 14:01
 */
@Component
@ConfigurationProperties(prefix = "people")
public class StaticPeople {

    @Value("${people.name}")
    public static String name;

    @Value("${people.age}")
    public static String age;

    @Value("${people.education}")
    public static String education;

    @Value("${people.sex}")
    public static String sex;

    @Value("${people.name}")
    public void setName(String name) {
        StaticPeople.name = name;
    }

    @Value("${people.age}")
    public void setAge(String age) {
        StaticPeople.age = age;
    }

    @Value("${people.education}")
    public void setEducation(String education) {
        StaticPeople.education = education;
    }

    @Value("${people.sex}")
    public void setSex(String sex) {
        StaticPeople.sex = sex;
    }
}
