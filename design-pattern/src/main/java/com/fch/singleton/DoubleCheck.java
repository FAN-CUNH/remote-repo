package com.fch.singleton;

/**
 * @packageName com.fch.singleton
 * @ClassName DoubleCheck
 * @Description TODO 双重检查 (线程安全；延迟加载；效率较高 同步方法 推荐使用)
 * @Author Fan-CUNH
 * @Date 2023/8/1 15:10
 * @Version 1.0
 */
public class DoubleCheck {
    // 1.私有的静态成员变量
    private static volatile DoubleCheck singleton;

    // 2.私有的构造器
    private DoubleCheck() {}

    // 3.静态的公有方法
    public static DoubleCheck getInstance() {
        // 单线程此处分流
        if (singleton == null) {
            synchronized (DoubleCheck.class) {
                // 多线程此处分流
                if (singleton == null) {
                    singleton = new DoubleCheck();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println("DoubleCheck.getInstance().hashCode() = " + DoubleCheck.getInstance().hashCode());
        System.out.println("DoubleCheck.getInstance().hashCode() = " + DoubleCheck.getInstance().hashCode());
    }

    //DoubleCheck.getInstance().hashCode() = 1435804085
    //DoubleCheck.getInstance().hashCode() = 1435804085
}
