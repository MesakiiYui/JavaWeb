package com.mesakiiyui.dm.common.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author: jintienan
 * @Date: 2021/2/20 14:47
 */
@Service
public class SpringELService {
    @Value("其它类的属性")
    private String anotherValue;

    public String getAnotherValue() {
        return anotherValue;
    }

    public void setAnotherValue(String anotherValue) {
        this.anotherValue = anotherValue;
    }
}
