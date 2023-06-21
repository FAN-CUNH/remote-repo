package javase.day20.unitwork;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatch_work
 * @Description 使用CountDownLatch完成 定义2个线程，第一个线程打印线程id；
 * 第二个线程打印线程id以及系统时间；第一个线程打印线程名
 * @Author Cunhao Fan
 * @Date 2023/5/7 15:20
 * @Version 1.0
 */
public class CountDownLatch_work {
    public static void main(String[] args) {
        /*实例化CountDownLatch对象*/
        CountDownLatch countDownLatch = new CountDownLatch(1);
        /*创建第一个线程*/
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println(this.getId());
                /*调用await(),等待线程2先执行*/
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName());
            }
        };

        /*创建第二个线程*/
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println(this.getId() + System.currentTimeMillis());
                /*调用countDown,表示自己执行完了，解除线程1的阻塞状态*/
                try {
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        /*启动线程*/

        thread1.start();
        thread2.start();
    }
}
