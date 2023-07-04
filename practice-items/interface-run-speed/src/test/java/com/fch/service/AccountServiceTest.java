package com.fch.service;

import com.fch.config.SpringConfig;
import com.fch.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @packageName com.fch.service
 * @ClassName AccountServiceTest
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/3 20:28
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void testFindById() {
        Account account = accountService.findById(2);
        System.out.println("account = " + account);
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = accountService.findAll();
        System.out.println("accounts = " + accounts);
    }

    @Test
    public void testGetDataSource() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource dataSource = context.getBean(DataSource.class);
        System.out.println("dataSource = " + dataSource.getConnection());
    }
}
