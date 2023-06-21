package javase.day19.thread_demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MyTicket
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/4 13:00
 * @Version 1.0
 */
public class MyTicket implements Runnable {
    /*资源 字段*/
    Integer ticket;
    /*内置锁*/
    //Object lock = new Object();
    /*锁*/
    Lock lock = new ReentrantLock();

    /*有参构造给ticket变量初始化*/
    public MyTicket(Integer ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        /*卖票 窗口永远开启*/
        while (true) {
            //synchronized (lock) { // 同步代码块 synchronized：同步锁
            lock.lock();
            if (ticket > 0) { // 有票 可以卖
                /*出票操作，并且使用sleep模仿一下出票时间*/
                try {
                    /*获取当前线程对象的名字*/
                    String name = Thread.currentThread().getName();
                    System.out.println(name + "正在卖：" + ticket--);
                    Thread.sleep(1000);
                    System.out.println("正在出票中...");
                    Thread.sleep(2000);
                    System.out.println("出票成功！");
                    System.out.println();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                break;
            }
            lock.unlock();
            //}
        }
    }
}
