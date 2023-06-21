package basejava.day6.work;

import java.util.Arrays;
import java.util.Scanner;

public class Work8 {
    // 键盘录入一串字符串以空格隔开，输出的时候将每个单词的首字母变成大写
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 获取键盘录入
        System.out.println("请输入一串字符串以空格隔开：");
        String str = scanner.nextLine(); // scanner.nextLine --> 是以enter建作为结束标准的
        String [] strArray = str.split(" "); // 将输入的字符串以空格分割，存入数组
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].charAt(0) >= 'a' && strArray[i].charAt(0) <= 'z'){ // 确定元素首字母是小写
                strArray[i] = strArray[i].replace(strArray[i].charAt(0),(char)(strArray[i].charAt(0)-32)); // replace方法将数组元素首字母变成大写
                // strArray[i].charAt(0) = (char)(strArray[i].charAt(0)-32); 错误写法 不能将一个常量赋值给另一个常量
            }
        }
        System.out.println(Arrays.toString(strArray));
    }
}
