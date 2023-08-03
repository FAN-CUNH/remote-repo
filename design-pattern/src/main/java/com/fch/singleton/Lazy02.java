package com.fch.singleton;

/**
 * @packageName com.fch.singleton
 * @ClassName Lazy02
 * @Description TODO 懒汉式（线程安全，同步方法）
 * @Author Fan-CUNH
 * @Date 2023/8/1 14:57
 * @Version 1.0
 */
public class Lazy02 {
    // 私有成员变量
    private static Lazy02 singleton;
    // 私有的构造器
    private Lazy02() {}
    // 公有的静态方法上同步锁
    public static synchronized Lazy02 getInstance() {
        if (singleton == null) {
            singleton = new Lazy02();
        }
        return singleton;
    }

    public static void main(String[] args) {
        Lazy02 instance = Lazy02.getInstance();
        Lazy02 instance1 = Lazy02.getInstance();
        System.out.println("instance.hashCode() = " + instance.hashCode());
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
    }

    // instance.hashCode() = 1435804085
    // instance1.hashCode() = 1435804085
    // 单例
}
