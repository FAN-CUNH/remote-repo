package com.fch.singleton;

/**
 * @packageName com.fch.singleton
 * @ClassName Hungry01 饿汉式 (静态变量)
 * @Description TODO 1. 构造器私有化 （防止 new）
 *                   2. 类的内部创建对象
 *                   3. 向外暴露一个静态的公共方法
 * @Author Fan-CUNH
 * @Date 2023/8/1 14:24
 * @Version 1.0
 */
public class Hungry01 {
    //1. 构造器私有化，外部不能new
    private Hungry01() {
    }

    ;
    //2. 本类内部创建实例（静态变量形式）
    private final static Hungry01 INSTANCE = new Hungry01();

    //3. 向外暴露一个静态的公共方法
    public static Hungry01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        // 验证是否是单例 结果为true表示单例
        Hungry01 instance1 = Hungry01.getInstance();
        Hungry01 instance2 = Hungry01.getInstance();
        System.out.println(instance1 == instance2);
    }
}
