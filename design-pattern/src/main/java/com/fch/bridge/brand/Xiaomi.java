package com.fch.bridge.brand;

/**
 * @packageName com.fch.bridge.brand
 * @ClassName Xiaomi
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/3 11:25
 * @Version 1.0
 */
public class Xiaomi implements Brand {
    /**
     * 开机
     */
    @Override
    public void open() {
        System.out.println(" 小米手机开机 ");
    }

    /**
     * 关机
     */
    @Override
    public void close() {
        System.out.println(" 小米手机关机 ");
    }

    /**
     * 打电话
     */
    @Override
    public void call() {
        System.out.println(" 小米手机打电话 ");
    }
}
