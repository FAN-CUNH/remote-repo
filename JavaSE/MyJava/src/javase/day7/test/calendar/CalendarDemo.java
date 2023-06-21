package javase.day7.test.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName CalendarDemo
 * @Description 日历 抽象类 提供了静态方法实例化
 * @Author Cunhao Fan
 * @Date 2023/4/14 18:19
 * @Version 1.0
 */
public class CalendarDemo {
    public static void main(String[] args) {
        /*获取系统日历*/
        Calendar calendar = Calendar.getInstance();
        /*.get(日历字段的信息) 返回日历字段的信息 周日是第一天*/
        System.out.println("一周的第几天:"+calendar.get(Calendar.DAY_OF_WEEK));
        /*.add()*/
        /*往前推两天*/
        calendar.add(Calendar.DAY_OF_WEEK,-2);
        /*往前推两周*/
        calendar.add(Calendar.WEEK_OF_MONTH,-2);
        Date date = calendar.getTime();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strData = simpleDateFormat.format(date);
        System.out.println(strData);
    }
}
