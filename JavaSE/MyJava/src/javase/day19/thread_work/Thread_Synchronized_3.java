package javase.day19.thread_work;

/**
 * @ClassName Thread_Synchronized_3
 * @Description 请按如下要求编写多线程程序：
 * 		        1. 创建两个类，一个是测试类，一个是Thread的子类；
 * 		        2. 在测试类中，创建两个Thread类的子类对象，将其中的一个线程对象的优先级设置10，另一个线程对象的优先级设置为6。
 * 		        3. 让优先级为10的线程打印5次“线程1正在运行”，让优先级为6的线程打印10次“线程2正在运行”；
 * @Author Cunhao Fan
 * @Date 2023/5/4 19:45
 * @Version 1.0
 */
public class Thread_Synchronized_3 {
    public static void main(String[] args) {
        /*创建线程任务对象*/
        MyThread myThread = new MyThread();
        /*创建线程*/
        Thread thread1 = new Thread(myThread, "线程1");
        Thread thread2 = new Thread(myThread, "线程2");
        /*设置优先级并且启动线程*/
        thread1.setPriority(10);
        thread2.setPriority(6);
        thread1.start();
        thread2.start();
    }
}
