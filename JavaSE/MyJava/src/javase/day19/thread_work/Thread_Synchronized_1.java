package javase.day19.thread_work;

/**
 * @ClassName Thread_Synchronized_1
 * @Description 使用3个线程模拟电影院3个窗口同时卖票的过程，总票数量为100张。
 *              在卖票的过程要考虑到线程同步的问题，不能出现多卖、少卖、重复卖票的情况。
 * @Author Cunhao Fan
 * @Date 2023/5/4 18:50
 * @Version 1.0
 */
public class Thread_Synchronized_1 {
    public static void main(String[] args) {
        /*创建线程任务对象*/
        MyTicket myTicket = new MyTicket();
        /*创建线程*/
        Thread thread1 = new Thread(myTicket, "窗口1");
        Thread thread2 = new Thread(myTicket, "窗口2");
        Thread thread3 = new Thread(myTicket, "窗口3");
        /*启动线程*/
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
