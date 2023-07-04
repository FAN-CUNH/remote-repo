package com.fch.service;

import com.fch.pojo.Account;

import java.util.List;

/**
 * @packageName com.fch.service
 * @ClassName AccountService
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/3 20:06
 * @Version 1.0
 */
public interface AccountService {
    Account findById(Integer id);

    List<Account> findAll();
}
