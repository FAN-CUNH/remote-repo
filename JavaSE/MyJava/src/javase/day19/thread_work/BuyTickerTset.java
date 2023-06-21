package javase.day19.thread_work;

import java.util.Scanner;

/**
 * @ClassName BuyTickerTset
 * @Description 编写多线程同步程序，模拟3个人排除买票，张某、李某和赵某买电影票，售票员只有3张五元的钱，
 *              电影票5元一张。张某拿20元一张的RMB排在李某的前面，李某排在赵某的前面拿一张10元的RMB买票，赵某拿一张5元的RMB买票。
 * @Author Cunhao Fan
 * @Date 2023/5/4 20:31
 * @Version 1.0
 */
public class BuyTickerTset {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入人民币面值：");
        int money = s.nextInt();
        /*创建买票任务*/
        BuyTicket buyTicket = new BuyTicket(money);
        /*创建卖票线程*/
        Thread thread1 = new Thread(buyTicket, "张某");
        Thread thread2 = new Thread(buyTicket, "李某");
        Thread thread3 = new Thread(buyTicket, "赵某");
        /*启动线程*/
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
