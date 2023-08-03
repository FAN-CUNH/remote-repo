package com.fch.singleton;

/**
 * @packageName com.fch.singleton
 * @ClassName StaticInnerClasses
 * @Description TODO 静态内部类实现单例模式 （静态内部类加载时是线程安全的）
 *                   优点：1.这种方式采用了类装载的机制来保证初始化实例时只有一个线程。
 *                        2.静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化
 *                        3.类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 *                        4.避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
 *                        5.结论:推荐使用.
 * @Author Fan-CUNH
 * @Date 2023/8/1 15:21
 * @Version 1.0
 */
public class StaticInnerClasses {
    private StaticInnerClasses singleton;
    // JVM在装载类的时候线程是安全的，所以保证了 INSTANCE 是单例模式
    private static class SingletonInstance {
        private static final StaticInnerClasses INSTANCE = new StaticInnerClasses();
    }

    public static StaticInnerClasses getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public static void main(String[] args) {
        StaticInnerClasses instance = StaticInnerClasses.getInstance();
        StaticInnerClasses instance1 = StaticInnerClasses.getInstance();
        System.out.println("instance.hashCode() = " + instance.hashCode());
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
    }
    //instance.hashCode() = 1784662007
    //instance1.hashCode() = 1784662007
}
