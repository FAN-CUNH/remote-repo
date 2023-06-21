package basejava.day2.work;

import java.util.Scanner;

public class Work6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生性别:"); // 男;0 女：1
        String  sex = scanner.next();
        System.out.println(sex.equals("0") ? "男" : (sex.equals("1")?"女":"error"));
    }
}
