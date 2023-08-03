package com.fch.singleton;

/**
 * @packageName com.fch.singleton
 * @ClassName Hungry02
 * @Description TODO 饿汉式（静态代码块）
 * @Author Fan-CUNH
 * @Date 2023/8/1 14:41
 * @Version 1.0
 */
public class Hungry02 {
    //1. 构造器私有化
    private Hungry02() {};
    //2. 私有静态成员变量
    private static Hungry02 instance;
    static {
        instance = new Hungry02();
    }
    //3. 对外提供公有的静态方法
    public static Hungry02 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Hungry02 instance1 = Hungry02.getInstance();
        Hungry02 instance2 = Hungry02.getInstance();
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
        System.out.println("instance2.hashCode() = " + instance2.hashCode());

        // instance1.hashCode() = 1435804085
        // instance2.hashCode() = 1435804085
        // 两个实例对象的hashCode值相同，单例
    }
}
