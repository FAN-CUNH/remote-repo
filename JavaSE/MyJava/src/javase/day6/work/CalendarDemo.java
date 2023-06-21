package javase.day6.work;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName CalendarDemo
 * @Description 自行学习Calendar类，使用其方法计算500天后是几几年几月几日
 * @Author Cunhao Fan
 * @Date 2023/4/13 17:04
 * @Version 1.0
 */
public class CalendarDemo {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd E");
        /*获取系统日历*/
        Calendar calendar = Calendar.getInstance();
        /*获取当天是这周的第几天，周日是第一天*/
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        /*将日历时间往前推weekday天*/
        calendar.add(Calendar.DAY_OF_WEEK,-weekDay);
        for (int i = 0; i < 7; i++) {
            /*每次往后推一天*/
            calendar.add(Calendar.DAY_OF_WEEK, +1);
            /*将日历转成Data类型*/
            Date date = calendar.getTime();
            System.out.println(simpleDateFormat.format(date));
        }
        /*获取当天是这月的第几天*/
        int monthDay = calendar.get(Calendar.DAY_OF_MONTH);
        /*将日历时间往前推monthday天*/
        calendar.add(Calendar.DAY_OF_MONTH,-monthDay);
        for (int i = 0; i < 30; i++) {
            /*每次往后推一天*/
            calendar.add(Calendar.DAY_OF_MONTH,+1);
            Date date = calendar.getTime();
            String strMonthDay = simpleDateFormat.format(date);
            System.out.print(strMonthDay+"\t");
            if (i%7==1){
                System.out.println();
            }
        }
    }
}
