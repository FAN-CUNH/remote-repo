package com.fch.service.impl;

import com.fch.dao.UserDao;
import com.fch.service.UserService;
import lombok.Data;

/**
 * @packageName com.fch.service.impl
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/29 15:11
 * @Version 1.0
 */
@Data
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public void init() {
        userDao.init();
        System.out.println("UserServiceImpl is init...");
    }

}
