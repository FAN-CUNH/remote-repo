package javase.day19.thread_work;

import java.util.ArrayList;
import java.util.Random;

/**
 * @ClassName Thread_Synchronized_2
 * @Description 请按如下要求编写多线程程序：
 * 			    1.得到一个随机的整数n，创建n个子线程对象；
 * 			    2.要求在子线程中把当前线程的名称作为元素添加一个集合中；
 * @Author Cunhao Fan
 * @Date 2023/5/4 19:02
 * @Version 1.0
 */
public class Thread_Synchronized_2 {
    public static void main(String[] args) {
        ArrayList<String> List = new ArrayList<String>();
        Random random = new Random();
        /*生成一个1-10的随机数*/
        int num = random.nextInt(10)+1;
        MyNumber myNumber = new MyNumber(List, num);
        while (num > 0) {
            Thread thread = new Thread(myNumber, "线程"+num--);
            thread.start();
        }
        //List.forEach(System.out::println);
    }
}
