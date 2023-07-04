package com.fch.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @packageName com.fch.pojo
 * @ClassName Person
 * @Description 人物
 * @Author Fan-CUNH
 * @Date 2023/7/3 15:06
 * @Version 1.0
 */

@Data
@Component
public class Person {
    @Value("1") // 无参，setting 注入
    private Integer personId;
    @Value("张三") // 无参，setting 注入
    private String name;
    //@Autowired // 先匹配对象名，再匹配类型
    @Resource // 先匹配类型，再匹配对象名
    //@Qualifier("cat") // 指定要注入对象
    private Animal animal;
}
