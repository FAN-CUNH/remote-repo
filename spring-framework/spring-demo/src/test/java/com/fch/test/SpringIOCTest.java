package com.fch.test;

import com.fch.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @packageName com.fch.test
 * @ClassName SpringIOCTest
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/29 10:34
 * @Version 1.0
 */
public class SpringIOCTest {

    @Test
    public void springIOC() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        User user = (User) context.getBean("user");
        System.out.println("user = " + user);
    }
}
