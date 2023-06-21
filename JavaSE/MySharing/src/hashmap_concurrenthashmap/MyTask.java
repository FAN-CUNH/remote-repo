package hashmap_concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName MyTask
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/9 13:49
 * @Version 1.0
 */
public class MyTask implements Runnable {
    /*成员变量*/
    //public final String KEY = "key";
    private final ConcurrentHashMap<String, Integer> map;

    /*有参构造*/
    public MyTask(ConcurrentHashMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            map.put(Thread.currentThread().getName() + i, i);
        }
        System.out.println(map.size());
    }

}
