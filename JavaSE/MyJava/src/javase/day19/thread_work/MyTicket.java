package javase.day19.thread_work;

/**
 * @ClassName MyTicket
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/4 18:51
 * @Version 1.0
 */
public class MyTicket implements Runnable{
    /*资源字段，表示总票数*/
    int ticket = 100;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    /*有票 -> 卖票*/
                    int newTicket = ticket--;
                    System.out.println("出票中...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"正在卖编号为"+newTicket+"电影票！");
                }
            }
        }
    }
}
