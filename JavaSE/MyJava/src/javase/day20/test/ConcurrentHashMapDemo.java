package javase.day20.test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ConcurrentHashMap
 * @Description 整不明白！！！
 * @Author Cunhao Fan
 * @Date 2023/5/6 10:47
 * @Version 1.0
 */

class Task extends Thread {
    public static ConcurrentHashMap<Long, String> map = new ConcurrentHashMap<>();

    public Task(String name) {
        super(name);
    }

    @Override
    public void run() {
        map.put(Thread.currentThread().getId(), Thread.currentThread().getName());
        //System.out.println(Task.map.size()+" "+Thread.currentThread().getName());
    }
}

public class ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        int i = 1;
        while (i <= 10) {
            Thread thread = new Task("线程"+ i++);
            thread.start();
        }
        Thread.sleep(5000);
        System.out.println(Task.map);
        System.out.println(Task.map.size());
    }
}
