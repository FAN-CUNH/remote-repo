package com.fch.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @packageName com.fch.aspect
 * @ClassName BaseAdvice
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/3 21:02
 * @Version 1.0
 */

@Aspect
@Component
public class BaseAdvice {
    @Pointcut("execution(* com.fch.service.*Service.*(..))")
    private void servicePt() {
    }

    @Around("servicePt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 获取执行签名信息
        Signature signature = pjp.getSignature();
        // 通过签名获取执行操作名称（接口名）
        String className = signature.getDeclaringTypeName();
        // 通过签名获取执行操作名称（方法名）
        String methodName = signature.getName();

        // 开始执行程序
        long start = System.currentTimeMillis();
        Object proceed = null;
        for (int i = 0; i < 10000; i++) {
            proceed = pjp.proceed();
        }
        // 程序执行结束
        long end = System.currentTimeMillis();
        System.out.println("万次执行: " + className + "." + methodName + "--->" + (end - start) + "ms");
        return proceed;
    }
}
