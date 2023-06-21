package javase.day19.thread_work;

import java.util.ArrayList;

/**
 * @ClassName MyRunnable
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/4 20:04
 * @Version 1.0
 */
public class MyRunnable implements Runnable{
    ArrayList<String> list;
    int threadCount;

    public MyRunnable(ArrayList<String> list, int threadCount) {
        this.list = list;
        this.threadCount = threadCount;
    }

    @Override
    public void run() {
        synchronized (this) {
            if (threadCount > 0) {
                list.add(Thread.currentThread().getName());
                threadCount--;
            }
            if (threadCount == 0) {
                System.out.println(list);
            }
        }
    }
}
