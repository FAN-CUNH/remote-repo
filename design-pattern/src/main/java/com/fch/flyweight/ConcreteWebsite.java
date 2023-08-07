package com.fch.flyweight;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.flyweight
 * @ClassName ConcreteWebsite
 * @Description TODO 具体的享元对象
 * @Author Fan-CUNH
 * @Date 2023/8/5 14:53
 * @Version 1.0
 */
@Slf4j
public class ConcreteWebsite extends Website {
    /**
     * 网站的发布形式（类型）
     */
    private String type;

    public ConcreteWebsite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        log.info("网站的发布形式：{}, 所属人：{}", type, user);
    }
}
