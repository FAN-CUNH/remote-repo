package javase.day19.thread_demo;

/**
 * @ClassName ThreadText
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/4 12:35
 * @Version 1.0
 */
public class ThreadText {
    /*main程序 -> 应用程序*/
    public static void main(String[] args) {
        // 任务1 -> 新建线程1
        Thread thread1 = new MyThread("第一个任务");
        System.out.println(thread1.getId()+" "+thread1.getName());
        thread1.start();
        // 任务2 -> 新建线程2
        Thread thread2 = new MyThread("第二个任务");
        System.out.println(thread2.getId()+" "+thread2.getName());
        thread2.start();
        /*创建100个线程并执行*/
        for (int i = 0; i <= 100 ; i++) {
            Thread thread = new MyThread("第"+i+"个任务");
            thread.start();
        }
    }
}
