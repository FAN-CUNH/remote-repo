package com.fch.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "emp")
public class Emp {
    private String name;
    private Integer age;
    private String image;
    private String gender;
    private String job;

    // 一对一 list 列表
    private List<Address> addresses;

    // 一对多 map 集合
    private Map<String, List<Address>> someAddress;
}
