package javase.day19.thread_work;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/4 19:46
 * @Version 1.0
 */
public class MyThread implements Runnable{
    /*创建一个锁*/
    private final Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            if (Thread.currentThread().getPriority() == 10) {
                int times = 5;
                while (times > 0) {
                    System.out.println("线程1正在运行！");
                    times--;
                }
            }
            else if (Thread.currentThread().getPriority() == 6){
                int times = 10;
                while (times > 0) {
                    System.out.println("线程2正在运行！");
                    times--;
                }
            }
        }
    }
}
