package com.fch.bridge.brand;

/**
 * @packageName com.fch.bridge
 * @ClassName Brand
 * @Description TODO 手机品牌接口
 * @Author Fan-CUNH
 * @Date 2023/8/3 11:23
 * @Version 1.0
 */
public interface Brand {
    /**
     * 开机
     */
    void open();

    /**
     * 关机
     */
    void close();

    /**
     * 打电话
     */
    void call();
}
