package javase.day19.thread_work;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Thread_Synchronized_2_2
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/4 20:00
 * @Version 1.0
 */
public class Thread_Synchronized_2_2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Random random = new Random();
        int threadCount = random.nextInt((10)+1);
        ExecutorService service = Executors.newFixedThreadPool(threadCount);
        MyRunnable myRunnable = new MyRunnable(list, threadCount);
        while (threadCount > 0) {
            service.submit(myRunnable);
            threadCount--;
        }
        //list.forEach(System.out::println);
    }
}
