package javase.day4.work.work3;

import java.util.Timer;
import java.util.TimerTask;

public class TinerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer(); // 实例化Timer计数器
        TimerTask timerTask = new TimerTaskChild();
        timer.schedule(timerTask,1000,1000); // 任务，延迟，间隔
    }


}
