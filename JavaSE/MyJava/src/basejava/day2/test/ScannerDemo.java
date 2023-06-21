package basejava.day2.test;

import java.util.Scanner;

public class ScannerDemo { // 键盘录入姓名，年龄，身高，一句话
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String username = scanner.next(); // 按Enter\空格键结束
        System.out.println("输入的用户名为："+username);
        System.out.println("请输入年龄：");
        int age = scanner.nextInt(); // 输入的格式为整数
        System.out.println("输入的年龄为："+age); // 按Enter\空格键结束
    }
}
