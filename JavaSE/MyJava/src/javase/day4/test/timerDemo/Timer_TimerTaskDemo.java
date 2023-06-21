package javase.day4.test.timerDemo;

import java.util.Timer;
import java.util.TimerTask;

public class Timer_TimerTaskDemo {
    public static void main(String[] args) {
        Timer timer = new Timer(); // 实例化Timer定时器
        Timer timer1 = new Timer();

        TimerTask timerTask = new TimerTaskChild();
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        };
        System.out.println("2");
        timer.schedule(timerTask,2000);
        timer.schedule(timerTask1,3000);

    }
}
