package com.fch;

import com.fch.pojo.Emp;
import com.fch.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class SpringbootApplicationTests {

    @Resource
    private User user;

    @Resource
    private Emp emp;

    @Test
    void contextLoads() {
        log.info("user = {}", user);
        log.warn("emp = {}", emp);
    }

}
