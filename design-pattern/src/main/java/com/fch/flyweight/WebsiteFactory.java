package com.fch.flyweight;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @packageName com.fch.flyweight
 * @ClassName WebsiteFactory
 * @Description TODO 享元工厂 根据具体的需求返回对应的享元对象
 * @Author Fan-CUNH
 * @Date 2023/8/5 14:56
 * @Version 1.0
 */
@Slf4j
public class WebsiteFactory {
    /**
     * 集合 充当池的作用
     */
    private HashMap<String, ConcreteWebsite> pool = new HashMap<>(16);

    /**
     * 根据入参类型返回对应的网站类型
     * 如果池中存在则直接返回
     * 否则创建该类型网站并放入池中，再返回
     *
     * @param type 网站类型
     * @return 具体网站对象
     */
    public Website getWebsite(String type) {
        if (!pool.containsKey(type)) {
            pool.put(type, new ConcreteWebsite(type));
        }
        return pool.get(type);
    }

    /**
     * @return 池中的键值对 即网站类型的个数
     */
    public void getWebsiteCount() {
        log.info("池中网站类型个数：{}", pool.size());
    }
}
