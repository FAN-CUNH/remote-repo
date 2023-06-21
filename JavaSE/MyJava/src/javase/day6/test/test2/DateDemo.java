package javase.day6.test.test2;

import java.time.LocalDateTime;

public class DateDemo {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        /*
        * 获取年月日时分秒
        * 将系统时间变成2023/4/12 下午3点53分这样的格式打印出来
        * */
        int year = localDateTime.getYear();
        int month = localDateTime.getMonth().getValue();
        int day = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        /*如果此刻时间大于12点 则将小时减去12，并添加描述信息于时间前*/
        String mess = "上午";
        if (hour >  12){
            hour = hour - 12;
            mess = "下午";
        }
        String time = ""+year+"/"+month+"/"+day+" "+mess+hour+":"+minute+":"+second;
        System.out.println(time);

    }
}
