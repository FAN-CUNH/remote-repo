package basejava.day3.work;

import java.util.Scanner;

public class Work1 {
    public static void main(String[] args) {
        // 键盘录入A-Z范围内的字符，输入对应的小写
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入A-Z之内的字母：");
        String c = scanner.next();
        char ch = c.charAt(0); // 取字符串中的单个字符
        if (ch>='A' && ch<='Z'){ // ASCII码值a-z 97-122 A-Z 65-90
            System.out.println((char)(ch+32)); // 将得到的字符+32得到小写

        }else {
            System.out.println("输错啦！");
        }
    }
}
