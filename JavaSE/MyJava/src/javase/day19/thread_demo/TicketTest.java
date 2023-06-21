package javase.day19.thread_demo;

/**
 * @ClassName TicketTest
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/4 13:09
 * @Version 1.0
 */
public class TicketTest {
    public static void main(String[] args) {
        /*创建线程任务对象*/
        MyTicket myTicket = new MyTicket(1000);
        /*创建线程对象*/
        Thread thread1 = new Thread(myTicket, "窗口1");
        Thread thread2 = new Thread(myTicket, "窗口2");
        Thread thread3 = new Thread(myTicket, "窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
