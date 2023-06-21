package javase.day19.thread_work;

import java.util.ArrayList;

/**
 * @ClassName MyNumber
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/4 19:03
 * @Version 1.0
 */
public class MyNumber implements Runnable {
    /*存放子线程的名称*/
    ArrayList<String> List;
    int threadCount = 0;

    public MyNumber(ArrayList<String> numList, int threadCount) {
        this.List = numList;
        this.threadCount = threadCount;
    }

    @Override
    public void run() {
            synchronized (this) {
                //if (threadCount > 0) {
                    List.add(Thread.currentThread().getName());
                    threadCount--;
                //}
                if (threadCount == 0) {
                    System.out.println(List);
                }
            }
    }
}
