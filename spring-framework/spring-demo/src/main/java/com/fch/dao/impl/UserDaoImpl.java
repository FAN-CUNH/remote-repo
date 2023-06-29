package com.fch.dao.impl;

import com.fch.bean.User;
import com.fch.dao.UserDao;
import lombok.Data;

/**
 * @packageName com.fch.dao.impl
 * @ClassName UserImpl
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/29 15:21
 * @Version 1.0
 */

@Data
public class UserDaoImpl implements UserDao {
    private User user;

    @Override
    public void init() {
        System.out.println("UserDaoImpl is init...");
        System.out.println("user = " + user);
    }
}
