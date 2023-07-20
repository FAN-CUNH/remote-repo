package com.fch.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.fch.domain.User;
import com.fch.mapper.UserMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @packageName com.fch.service
 * @ClassName UserServiceImpl
 * @Description User业务接口实现
 * @Author Fan-CUNH
 * @Date 2023/7/19 11:32
 * @Version 1.0
 */
@Service(interfaceClass = UserService.class)
@Transactional
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    /**
     * @param username 通过用户姓名查询信息（包含用户信息、角色信息、权限信息）
     * @return 用户信息、角色信息、权限信息
     */
    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }
}
