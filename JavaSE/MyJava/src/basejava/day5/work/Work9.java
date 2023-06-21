package basejava.day5.work;

import java.util.Scanner;

public class Work9 {
    // 键盘录入字符串表示人名，要求人名中不能出现字母； 标记思想
    public static boolean isNoChar (String str){
        // 遍历str，当出现字母时返回error
        boolean existChar = false; // 假设不存在
        for (int i = 0; i < str.length(); i++) { // 验证是否真的不存在
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' ) { // 是否字母
                existChar = true; // 存在赋值true
                break; // 结束循环
            }
        }
        return existChar;
    }

    //主方法
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 键盘录入
        System.out.println("请输入姓名：");
        String str = scanner.next();
        // 调用isNoChar方法 不存在字母打印姓名 存在字母输出姓名不合法
        if (!isNoChar(str))
            System.out.println("你输入的姓名为："+str);
        else
            System.out.println("你输入的姓名输出姓名不合法！！！");
    }
}
