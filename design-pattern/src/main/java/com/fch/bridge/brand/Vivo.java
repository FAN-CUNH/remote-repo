package com.fch.bridge.brand;

/**
 * @packageName com.fch.bridge.brand
 * @ClassName Vivo
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/3 11:27
 * @Version 1.0
 */
public class Vivo implements Brand {
    /**
     * 开机
     */
    @Override
    public void open() {
        System.out.println(" Vivo手机开机 ");
    }

    /**
     * 关机
     */
    @Override
    public void close() {
        System.out.println(" Vivo手机关机 ");
    }

    /**
     * 打电话
     */
    @Override
    public void call() {
        System.out.println(" Vivo手机打电话 ");
    }
}
