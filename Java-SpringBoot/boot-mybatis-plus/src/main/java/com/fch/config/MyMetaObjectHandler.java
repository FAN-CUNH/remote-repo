package com.fch.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @packageName com.fch.config
 * @ClassName MyMetaObjectHandler
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/28 16:24
 * @Version 1.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * @param metaObject 插入时自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "createTime", LocalDateTime.now());
        this.fillStrategy(metaObject, "updateTime", LocalDateTime.now());
        this.fillStrategy(metaObject, "version", 1);
    }

    /**
     * @param metaObject 更新时自动填充
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "updateTime", LocalDateTime.now());
    }
}
