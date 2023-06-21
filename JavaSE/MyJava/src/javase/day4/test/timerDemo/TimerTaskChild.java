package javase.day4.test.timerDemo;

import java.util.TimerTask;

public class TimerTaskChild extends TimerTask {
    @Override
    public void run() {
        System.out.println("子类实例化");
    }



}
