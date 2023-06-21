package basejava.day2.work;

import java.util.Scanner;

public class Work4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年龄：");
        int age = scanner.nextInt(); // erter\空格 结束
        System.out.println(age % 2 == 0 ? "even" : "odd"); // 是偶数输出even 是奇数输出odd
    }
}
