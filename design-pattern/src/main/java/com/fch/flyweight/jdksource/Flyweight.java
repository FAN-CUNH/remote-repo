package com.fch.flyweight.jdksource;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.flyweight.jdksource
 * @ClassName Flyweight
 * @Description TODO JDK源码中的享元模式
 *                   Integer 的整数、或Integer.valueof(x)的x在-128 - 127之间，就是使用的享元模式，如果存在则返回相应的实例，否则新建
 * @Author Fan-CUNH
 * @Date 2023/8/5 15:51
 * @Version 1.0
 */
@Slf4j
public class Flyweight {
    public static void main(String[] args) {
        Integer x = 127;
        Integer y = new Integer(127);

        Integer z = Integer.valueOf(127);
        Integer w = new Integer(127);

        Integer a = 200;
        Integer b = 200;
        Integer c = Integer.valueOf(200);
        Integer d = new Integer(200);

        log.info("x.equals(y) = {}", x.equals(y));
        log.info("x == y -> {}", x == y);
        log.info("x == z -> {}", x == z);
        log.info("x == w -> {}", x == w);
        log.info("y == w -> {}", w == y);

        log.info("========================================");

        log.info("a == b -> {}", a == b);
        log.info("a == c -> {}", a == c);
        log.info("a == d -> {}", a == d);
    }
}
