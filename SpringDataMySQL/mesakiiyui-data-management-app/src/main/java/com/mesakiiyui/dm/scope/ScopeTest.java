package com.mesakiiyui.dm.scope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: jintienan
 * @Date: 2021/1/4 14:48
 */
@Slf4j
public class ScopeTest {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService s2 = context.getBean(DemoSingletonService.class);
        DemoProtoTypeService p1 = context.getBean(DemoProtoTypeService.class);
        DemoProtoTypeService p2 = context.getBean(DemoProtoTypeService.class);
        log.info("s1 == s2 ?"+s1.equals(s2)); // true
        log.info("p1 == p2 ?"+p1.equals(p2)); // false

    }
}
