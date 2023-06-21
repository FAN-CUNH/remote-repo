package basejava.day2.test;

public class SanMu {
    public static void main(String[] args) {
        int shu = 24,shu2 = 28, shu3 = 98,max;
        // 比较三个数中的最大值？
        System.out.println((max = (shu > shu2 ? shu : shu2)) > shu3 ? max : shu3);
        //判断某个数是否是偶数？
        System.out.println(shu % 2 == 0 ? "偶数" : "奇数" );
        // 给定一个人的姓名，判断该人是否是张三，不是则打印姓名，是张三打印张三你好
        String  name = "李四";
        System.out.println(name.equals("张三") ? "张三你好" : name);
    }
}
