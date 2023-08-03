package com.fch.singleton;

/**
 * @packageName com.fch.singleton
 * @ClassName Enum
 * @Description TODO 使用枚举实现单例 (借助JDK1.5中添加的枚举来实现单例模式、不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象)
 * @Author Fan-CUNH
 * @Date 2023/8/1 15:35
 * @Version 1.0
 */
public enum Enum {
    INSTANCE;

    public static void main(String[] args) {
        System.out.println("instance.hashCode() = " + Enum.INSTANCE.hashCode());
        System.out.println("instance1.hashCode() = " + Enum.INSTANCE.hashCode());
    }
    //instance.hashCode() = 1435804085
    //instance1.hashCode() = 1435804085
}
