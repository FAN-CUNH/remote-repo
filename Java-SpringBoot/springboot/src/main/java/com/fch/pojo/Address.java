package com.fch.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @packageName com.fch.pojo
 * @ClassName Address
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/3 2:43
 * @Version 1.0
 */
@Data
public class Address {
    private String province;
    private String city;
}
