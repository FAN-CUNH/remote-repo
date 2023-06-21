package basejava.day2.work;

import java.util.Scanner;

public class Work3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String username = scanner.next(); // enter\空格 结束
        System.out.println(username.equals("wangwu")?"wangwu":"error");
        /*System.out.println("请输入年龄：");
        int age = scanner.nextInt();
        System.out.println("年龄："+age);
        System.out.println("请输入身高：");
        double height = scanner.nextDouble();
        System.out.println("身高："+height);
        System.out.println("请输入学生的基本信息：");
        String lineString = scanner.nextLine(); // 空格不是结束符，enter键是结束符
        System.out.println("基本信息："+lineString);*/
    }
}
