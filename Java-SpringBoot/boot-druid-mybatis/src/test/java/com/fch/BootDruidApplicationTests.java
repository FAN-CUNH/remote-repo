package com.fch;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class BootDruidApplicationTests {

    @Resource
    private JdbcTemplate jdbcTemplate;


    @Test
    void contextLoads() {
        Long count = jdbcTemplate.queryForObject("select count(0) from blog", Long.class);
        log.info("count = {}", count);
    }

}
