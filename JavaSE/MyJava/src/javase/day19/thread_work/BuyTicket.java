package javase.day19.thread_work;

/**
 * @ClassName BuyTicket
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/4 20:31
 * @Version 1.0
 */
public class BuyTicket implements Runnable{
    /*声明三个变量用来记录售票员手中不同人民币的张数*/
    int five = 3, ten = 0, twenty = 0, money;

    public BuyTicket(int money) {
        this.money = money;
    }
    public void change() {
        switch (money) {
            case 5: {
                System.out.println("出票中...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("出票成功！,您给我"+money+"元，正好一张票！");
            }
            case 20:{
                if (five >= 3) {
                    twenty+=1;
                    five-=3;
                    System.out.println("出票中...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("出票成功！,您给我"+money+"元, 找您"+(5*3)+"元");
                }
                else {
                    synchronized (this){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                this.notify();
            }
            case 10:{
                if (five > 1) {
                    ten += 1;
                    five -= 1;
                    System.out.println("出票中...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("出票成功！,您给我10元, 找您5元");
                }
                else {
                    synchronized (this){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                this.notify();
            }
        }
    }
    @Override
    public void run() {
        /**/
        synchronized (this) {
            change();
        }
    }
}
