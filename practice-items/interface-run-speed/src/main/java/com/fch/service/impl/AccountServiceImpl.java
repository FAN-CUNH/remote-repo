package com.fch.service.impl;

import com.fch.mapper.AccountMapper;
import com.fch.pojo.Account;
import com.fch.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @packageName com.fch.service.impl
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/3 20:06
 * @Version 1.0
 */

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public Account findById(Integer id) {
        return accountMapper.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();
    }
}
