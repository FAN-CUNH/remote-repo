package javase.day20.unitwork;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ConcurrentHashMap_1
 * @Description 使用ConcurrentHashMap完成用3个线程实现往Map中放置线程id加map.size()对应线程对象放入Map,
 * 键值对要求是15000对
 * @Author Cunhao Fan
 * @Date 2023/5/7 13:56
 * @Version 1.0
 */
class MyRunnable implements Runnable {
    /*声明一个Map成员变量，用于存储线程对象*/
    public static ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
    /*重写run方法，表示任务*/
    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            concurrentHashMap.put(i + Thread.currentThread().getName(), i);
        }
    }
}

public class ConcurrentHashMap_work {
    public static void main(String[] args) {
        /*实例化任务*/
        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable, "高铁");
        Thread thread2 = new Thread(myRunnable, "汽车");
        Thread thread3 = new Thread(myRunnable, "飞机");
        /*启动线程*/
        thread1.start();
        thread2.start();
        thread3.start();

        /*等待线程执行完毕*/
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*输出集合长度*/
        System.out.println(MyRunnable.concurrentHashMap);
        System.out.println(MyRunnable.concurrentHashMap.size());
    }
}
