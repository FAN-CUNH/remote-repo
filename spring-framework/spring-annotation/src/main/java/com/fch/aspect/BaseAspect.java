package com.fch.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @packageName com.fch.aspect
 * @ClassName BaseAspect
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/3 16:37
 * @Version 1.0
 */

@Aspect
@Component
public class BaseAspect {
    @Before(value = "execution(* com.fch.pojo..*.*(..))")
    public void before() {
        System.out.println("前置通知");
    }
    @After(value = "execution(* com.fch.pojo..*.*(..))")
    public void after() {
        System.out.println("后置通知");
    }
}
