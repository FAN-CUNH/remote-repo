package javase.day20.test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ConcurrentHashMapDemo2
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/7 15:24
 * @Version 1.0
 */
class CoucurrentHashMapClass{
    public static ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
}

class MyThread extends Thread {
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            CoucurrentHashMapClass.map.put(this.getName() + (i + 1), this.getName() + i + 1);
        }
        long end = System.currentTimeMillis();
        System.out.println(this.getName() + " 结束！用时：" + (end - start) + " 毫秒");
    }
}
public class ConcurrentHashMapDemo2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread a1 = new MyThread();
        MyThread a2 = new MyThread();
        a1.setName("线程1-");
        a2.setName("线程2-");

        a1.start();
        a2.start();
        //休息10秒，确保两个线程执行完毕
        Thread.sleep(1000 * 5);
        //打印集合大小
        System.out.println("Map大小：" + CoucurrentHashMapClass.map.size());
    }
}
