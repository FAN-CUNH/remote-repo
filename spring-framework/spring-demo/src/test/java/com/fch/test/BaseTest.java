package com.fch.test;

import com.fch.bean.Person;
import com.fch.bean.User;
import lombok.Value;
import org.junit.Test;
import com.fch.servlet.UserServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;

/**
 * @packageName com.fch.test
 * @ClassName BaseTest
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/29 15:29
 * @Version 1.0
 */
public class BaseTest {
    @Test
    public void autowireTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserServlet userServlet = context.getBean("userServlet", UserServlet.class);
        try {
            userServlet.init();
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void personTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Person person = context.getBean(Person.class);
        System.out.println("person = " + person);
    }

    @Test
    public void aspectTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        User user = context.getBean(User.class);
        System.out.println("user = " + user);
    }
}
