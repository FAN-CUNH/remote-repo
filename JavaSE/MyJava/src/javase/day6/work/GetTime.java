package javase.day6.work;

import java.util.Date;

/**
 * @ClassName GetTime
 * @Description 使用Date的getTime()(可以用其他方法)计算你活了多少天
 * @Author Cunhao Fan
 * @Date 2023/4/14 8:58
 * @Version 1.0
 */
public class GetTime {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getTime()/86400000);
    }
}
