package com.fch.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @packageName com.fch.config
 * @ClassName MybatisPlusConfig
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/28 14:21
 * @Version 1.0
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();

        // 分页插件拦截器
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        // 设置请求页面大于最大操作页后返回到首页
        paginationInnerInterceptor.setOverflow(true);
        // 设置单页请求限制数量 默认500条 -1L 表示不限制
        paginationInnerInterceptor.setMaxLimit(-1L);
        // 设置数据库方言
        paginationInnerInterceptor.setDbType(DbType.MYSQL);

        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);

        // 乐观锁插件拦截器
        OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor = new OptimisticLockerInnerInterceptor();

        mybatisPlusInterceptor.addInnerInterceptor(optimisticLockerInnerInterceptor);

        return mybatisPlusInterceptor;
    }
}
