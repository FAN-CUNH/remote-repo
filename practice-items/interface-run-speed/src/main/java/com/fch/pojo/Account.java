package com.fch.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @packageName com.fch.pojo
 * @ClassName Account
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/3 20:02
 * @Version 1.0
 */

@Data
@Component
public class Account {
    private Integer id;
    private String name;
    private Double money;
}
