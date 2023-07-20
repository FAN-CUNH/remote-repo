package com.fch.config;

import com.fch.service.SpringSecurityUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;


/**
 * @packageName com.fch.controller
 * @ClassName SpringSecurityConfig
 * @Description SpringSecurity配置类
 * @Author Fan-CUNH
 * prePostEnabled = true 会解锁 @PreAuthorize 和 @PostAuthorize 两个注解。从名字就可以看出@PreAuthorize 注解会在方法执行前进行验证，而 @PostAuthorize 注解会在方法执行后进行验证。
 * securedEnabled = true 会解锁 @Secured注解是用来定义业务方法的安全配置。在需要安全[角色/权限等]的方法上指定 @Secured，并且只有那些角色/权限的用户才可以调用该方法。@Secured缺点（限制）就是不支持Spring EL表达式。不够灵活。并且指定的角色必须以ROLE_开头，不可省略。
 * jsr250Enabled = true  启用 JSR-250 安全控制注解，这属于 JavaEE 的安全规范，就开启了 JavaEE 安全注解中的以下三个：
 *   1.@DenyAll： 拒绝所有访问
 *   2.@RolesAllowed({“USER”, “ADMIN”})： 该方法只要具有"USER", "ADMIN"任意一种权限就可以访问。这里可以省略前缀ROLE_，实际的权限可能是ROLE_ADMIN
 *   3.@PermitAll： 允许所有访问
 *
 * @Date 2023/7/19 11:00
 * @Version 1.0
 */

// 开启注解版 SpringSecurity
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private SpringSecurityUserDetailsService springSecurityUserDetailsService;

    /**
     * 加密后的格式一般为：
     * $2a$10$/bTVvqqlH9UiE0ZJZ7N2Me3RIgUCdgMheyTgV0B4cMCSokPa.6oCa
     * 加密后字符串的长度为固定的60位。其中：$是分割符，无意义；2a是bcrypt加密版本号；10是cost的值；而后的前22位是salt值；
     * 再然后的字符串就是密码的密文了。
     *
     * @return 使用 BCrypt 加密 将salt随机并混入最终加密后的密码，验证时也无需单独提供之前的salt，从而无需单独处理salt问题
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 认证管理器 -> 登录认证配置
     *
     * @param auth
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // 配置读取数据库中的数据
                .userDetailsService(springSecurityUserDetailsService)
                // 设置密码加密方式
                .passwordEncoder(bCryptPasswordEncoder());
    }

    /**
     * 解决静态资源拦截的问题，对静态资源放行
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/css/**", "/img/**", "/js/**", "/plugins/**", "/template/**");
    }

    /**
     * 授权
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 允许嵌套页面，即允许访问iframe的页面
                .headers().frameOptions().sameOrigin()

                // 注册url拦截器 permitAll() 允许访问 authenticated() 认证后可访问
                .and()
                .authorizeRequests()
                .antMatchers("/resources/**", "/login.html", "/login").permitAll()
                .antMatchers("/pages/**").authenticated()
                .anyRequest().authenticated()

                // 表单登录配置
                .and()
                .formLogin()
                .loginPage("/login.html")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .successHandler((httpServletRequest, httpServletResponse, authentication)
                        -> httpServletResponse.sendRedirect("/pages/main.html"))
                .failureForwardUrl("/login.html")

                // 表单登出配置
                .and()
                .logout()
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html").permitAll()

                // 无权限访问的页面 跳转到403页面
                //.and()
                //.exceptionHandling().accessDeniedPage("/pages/403.html")

                .and()
                .csrf().disable();
    }
}
