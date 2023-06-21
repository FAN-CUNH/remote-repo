package javase.day4.work.work3;

import java.util.TimerTask;

public class TimerTaskChild extends TimerTask {
    int i = 0;
    @Override
    public void run() {
        System.out.println(++i);
        if (i == 5){
            System.gc(); // 提醒系统进行垃圾回收 结束程序  Timer运行结束后，如果没有手动终止，那么则只有当系统的垃圾收集被调用的时候才会对其进行回收终止。
            cancel();
        }
    }
}
