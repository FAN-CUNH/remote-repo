package com.fch.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @packageName com.fch.aspect
 * @ClassName BaseAspect
 * @Description 自定义切面
 * @Author Fan-CUNH
 * @Date 2023/7/3 16:37
 * @Version 1.0
 */

@Aspect // @Aspect表明这是一个切面类
@Component
public class BaseAspect {
    // @Pointcut()表示切入点
    @Pointcut("execution(* com.fch.pojo..*.eat(..))")
    private void pt() {}

    @Pointcut("execution(* com.fch.pojo..*.say(..))")
    private void pt1() {}

    @Before("pt()")
    public void before() {
        System.out.println("前置通知");
    }
    @After(value = "pt()")
    public void after() {
        System.out.println("后置通知");
    }

    @Around("pt1()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("前置通知1");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("后置通知1");
    }
}
