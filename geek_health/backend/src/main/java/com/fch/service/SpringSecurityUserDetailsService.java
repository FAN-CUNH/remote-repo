package com.fch.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fch.domain.Permission;
import com.fch.domain.Role;
import com.fch.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName com.fch.service
 * @ClassName SpringSecurityUserDetailsService
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/19 17:19
 * @Version 1.0
 */
@Service
public class SpringSecurityUserDetailsService implements UserDetailsService {

    @Reference
    private UserService userService;

    /**
     * @param username 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据姓名在数据库中查询（角色，权限）
        User user = userService.selectUserByUsername(username);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    username,
                    user.getPassword(),
                    "1".equals(user.getStation()),
                    true,
                    true,
                    true,
                    getAuthority(user)
            );
        }

        return null;
    }

    /**
     * @param user 获取拥有的角色信息和权限信息
     * @return 返回
     */
    private List<GrantedAuthority> getAuthority(User user) {
        ArrayList<GrantedAuthority> list = new ArrayList<>(16);
        List<Role> roles = user.getRoles();
        // 获取登录账号的拥有的角色信息
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority(role.getKeyword()));
            List<Permission> permissions = role.getPermissions();
            for (Permission permission : permissions) {
                list.add(new SimpleGrantedAuthority(permission.getKeyword()));
            }
        }
        return list;
    }
}
