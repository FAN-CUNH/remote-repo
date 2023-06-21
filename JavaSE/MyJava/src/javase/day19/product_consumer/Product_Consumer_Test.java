package javase.day19.product_consumer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Product_Consumer_Test
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/4 16:00
 * @Version 1.0
 */

class ProduTask implements Runnable {
    static int no = 0;
    List<String> ziYuan;//资源
    Object lock = new Object();

    public ProduTask(List<String> ziYuan) {
        this.ziYuan = ziYuan;
    }

    @Override
    public void run() {
        //生产
        synchronized (ziYuan) {
            System.out.println(Thread.currentThread().getName());
            if (ziYuan.size() > 0) {
                //有产品，别生产了,等待
                try {
                    ziYuan.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                ziYuan.add("产品" + (++no));
                System.out.println(Thread.currentThread().getName() + "正在生产第" + (no) + "个产品");
                System.out.println(ziYuan);
                ziYuan.notify();//唤醒消费者来消费
            }
        }
    }
}

class ConsumerTask implements Runnable {
    List<String> ziYuan;//资源

    public ConsumerTask(List<String> ziYuan) {
        this.ziYuan = ziYuan;
    }

    @Override
    public void run() {
        //消费
        synchronized (ziYuan) {
            System.out.println(Thread.currentThread().getName());
            if (ziYuan.size() == 0) {//没有产品，通知生产者生产，自己等待
                try {
                    ziYuan.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println(Thread.currentThread().getName() + "正在消费");
                ziYuan.remove(0);
                System.out.println(ziYuan);
                ziYuan.notify();
            }
        }
    }
}

public class Product_Consumer_Test {
    public static void main(String[] args) {
        //资源
        List<String> list = new ArrayList<String>();
        //生产者任务
        Runnable pro = new ProduTask(list);
        //消费者任务
        Runnable consu = new ConsumerTask(list);
        //生产线程
        Thread thread = new Thread(pro, "生产者1");
        thread.start();
        Thread thread2 = new Thread(pro, "生产者2");
        thread2.start();
        //消费线程
        Thread thread1 = new Thread(consu, "消费者1");
        thread1.start();
        Thread thread3 = new Thread(consu, "消费者2");
        thread3.start();
    }
}
