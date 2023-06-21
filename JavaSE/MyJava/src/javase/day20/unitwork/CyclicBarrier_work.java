package javase.day20.unitwork;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @ClassName CyclicBarrier_work
 * @Description 使用CyclicBarrier完成操作集合，3个线程共同操作集合，各自往集合添加一个元素；
 *              等3个线程都完成添加后，第四个线程才能将集合元素打印出来
 * @Author Cunhao Fan
 * @Date 2023/5/7 16:57
 * @Version 1.0
 */
class MyTask1 extends Thread {
    CyclicBarrier cyclicBarrier;
    ArrayList<String> list;

    public MyTask1(String name, CyclicBarrier cyclicBarrier, ArrayList<String> list) {
        super(name);
        this.cyclicBarrier = cyclicBarrier;
        this.list = list;
    }

    @Override
    public void run() {
            list.add(Thread.currentThread().getName());
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyTask2 extends Thread {
    ArrayList<String> list;

    public MyTask2(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        list.forEach(s -> System.out.println(s+"到了！"));
        System.out.println("桃园结义正式开始！");
    }
}

public class CyclicBarrier_work {
    public static void main(String[] args) throws InterruptedException {
        /*实例化一个集合对象,存放线程名*/
        ArrayList<String> list = new ArrayList<>();

        /*实例化可循环利用屏障*/
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new MyTask2(list));

        /*创建线程3对象*/
        MyTask1 thread1 = new MyTask1("刘备", cyclicBarrier, list);
        MyTask1 thread2 = new MyTask1("关羽", cyclicBarrier, list);
        MyTask1 thread3 = new MyTask1("曹操", cyclicBarrier, list);

        /*启动线程*/
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
