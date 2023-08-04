package com.fch.composite.jdksource;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @packageName com.fch.composite.jdksource
 * @ClassName Composite
 * @Description TODO JDK源码分析 HashMap -> 组合模式
 * @Author Fan-CUNH
 * @Date 2023/8/4 11:15
 * @Version 1.0
 */
@Slf4j
public class Composite {
    public static void main(String[] args) {
        // put 插入叶子节点（leaf）
        Map<Integer, String> hashMap = new HashMap<>(16);
        hashMap.put(0, "西游记");

        // put
        Map<Integer, String> map = new HashMap<>(16);
        map.put(1, "红楼梦");
        map.put(2, "三国演义");

        // putAll 插入非叶子节点（node）
        hashMap.putAll(map);

        // 输出
        log.info("hashMap = " + hashMap);
    }
}
