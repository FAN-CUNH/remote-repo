package com.fch.singleton;

/**
 * @packageName com.fch.singleton
 * @ClassName Lazy01
 * @Description TODO 懒汉式（线程不安全）
 *                   优点：起到了懒加载的效果，但只能在单线程中使用
 *                   缺点：多线程并发情况下，可能会造成两个线程同时进入if条件且同时成立，此时就会造成单例失效
 * @Author Fan-CUNH
 * @Date 2023/8/1 14:48
 * @Version 1.0
 */
public class Lazy01 {
    private static Lazy01 singleton;
    private Lazy01() {};
    public static Lazy01 getInstance() {
        // 只有当singleton为null时才进行创建实例
        if (singleton == null) {
            singleton = new Lazy01();
        }
        return singleton;
    }

    public static void main(String[] args) {
        Lazy01 instance = Lazy01.getInstance();
        Lazy01 instance1 = Lazy01.getInstance();
        System.out.println("instance.hashCode() = " + instance.hashCode());
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
    }
    // instance.hashCode() = 1435804085
    // instance1.hashCode() = 1435804085
    // 两个实例hashCode相同，单例
}
