package com.fch.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @packageName com.fch.pojo
 * @ClassName Person
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/3 15:06
 * @Version 1.0
 */

@Data
@Component
public class Person {
    @Value("1")
    private Integer personId;
    @Value("张三")
    private String name;
    //@Autowired
    @Resource
    //@Qualifier("cat")
    private Animal animal;
}
