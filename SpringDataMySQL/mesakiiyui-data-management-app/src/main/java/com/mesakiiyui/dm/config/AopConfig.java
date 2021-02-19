package com.mesakiiyui.dm.config;


import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: jintienan
 * @Date: 2020/12/30 16:42
 */
@Aspect
@Component
public class AopConfig {
    /**
     * 切点为controller包下的所有public方法
     */
    @Pointcut("execution(public * com.mesakiiyui.dm.controller..*.*(..))")
    public void aop(){}

    @Before("aop()")
    public void beforeAop(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        System.out.println("方法请求路径" + request.getRequestURI());
        System.out.println("请求方式" + request.getMethod());
        System.out.println("请求参数" + JSON.toJSONString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "value",pointcut = "aop()")
    public void afterAop(JoinPoint joinPoint,Object value) {
        System.out.println("返回参数" + JSON.toJSONString(value));
    }
}

