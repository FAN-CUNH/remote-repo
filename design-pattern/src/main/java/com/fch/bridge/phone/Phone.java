package com.fch.bridge.phone;

import com.fch.bridge.brand.Brand;

/**
 * @packageName com.fch.bridge.phone
 * @ClassName Phone
 * @Description TODO 手机抽象类
 * @Author Fan-CUNH
 * @Date 2023/8/3 11:29
 * @Version 1.0
 */
public abstract class Phone {
    // 组合品牌
    private Brand brand;

    // 构造器
    public Phone(Brand brand) {
        super();
        this.brand = brand;
    }

    /**
     * 开机
     */
    protected void open() {
        this.brand.open();
    }

    /**
     * 关机
     */
    protected void close() {
        this.brand.close();
    }

    /**
     * 打电话
     */
    protected void call() {
        this.brand.call();
    }
}
