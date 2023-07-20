package com.fch.service;

import com.fch.domain.User;

/**
 * @packageName com.fch.service
 * @ClassName UserService
 * @Description User接口
 * @Author Fan-CUNH
 * @Date 2023/7/19 11:31
 * @Version 1.0
 */
public interface UserService {
    User selectUserByUsername(String username);
}
