package com.mesakiiyui.springdatamysql.common.entity.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: jintienan
 * @Date: 2020/7/31 15:44
 */
// 适用方法
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodInfo {
    String name() default "long";
    String data();
    int age() default 27;
}
