package com.fch.adapter.objectadapter;

/**
 * @packageName com.fch.adapter.classadapter
 * @ClassName Client
 * @Description TODO 客户端
 * @Author Fan-CUNH
 * @Date 2023/8/2 21:14
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 通过手机调用充电方法，经过适配器将220V电压转换为5V，实现充电
        new Phone().charging(new VoltageAdapter(new Voltage220V()));
    }
}
