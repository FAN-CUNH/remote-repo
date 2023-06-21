package basejava.day2.work;

import java.util.Scanner;

public class Work5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名和年龄：");
        String name = scanner.next();
        int sex = scanner.nextInt(); // 性别 0：女 1：男
        System.out.println((sex ==  0 || sex == 1)?"学生姓名是："+name+"性别:"+sex:"其他");
    }
}
