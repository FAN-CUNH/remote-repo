package com.fch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.fch.mapper")
@SpringBootApplication
public class BootDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootDruidApplication.class, args);
    }

}
