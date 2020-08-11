package com.mesakiiyui.springdatamysql.common.entity.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: jintienan
 * @Date: 2020/7/31 15:43
 */
// 适用field属性，也包括enum常量
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldInfo {
    int[] value();
}
