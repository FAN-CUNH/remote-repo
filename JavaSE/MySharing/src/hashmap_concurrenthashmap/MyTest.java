package hashmap_concurrenthashmap;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyTest
 * @Description 测试类
 * @Author Cunhao Fan
 * @Date 2023/5/9 13:48
 * @Version 1.0
 */
public class MyTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(test());
            System.out.println("===================");
        }
    }

    private static int test() throws InterruptedException {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
        /*创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。*/
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            pool.execute(new MyTask(map));
        }

        /*关闭了提交通道，停止接收新任务，已提交的任务会继续执行直到完成，此方法不会阻塞，当所有提交任务执行完毕，线程池被关闭*/
        pool.shutdown();
        /*使用awaitTermination时，主线程会处于一种等待的状态，等待线程池中所有的线程都运行完毕后才继续运行。*/
        pool.awaitTermination(1, TimeUnit.DAYS);
        return map.size();
    }
}
