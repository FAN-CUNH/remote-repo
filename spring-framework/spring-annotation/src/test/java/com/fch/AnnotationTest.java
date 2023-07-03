package com.fch;

import com.fch.config.SpringConfig;
import com.fch.pojo.Cat;
import com.fch.pojo.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @packageName com.fch
 * @ClassName AnnotationTest
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/3 14:48
 * @Version 1.0
 */
public class AnnotationTest {
    @Test
    public void annotationTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println("person = " + person);
        person.getAnimal().say();
        Cat cat = context.getBean(Cat.class);
        cat.eat();
    }
}
