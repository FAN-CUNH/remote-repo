package basejava.day5.work;

import java.util.Scanner;

public class Work8 {
    // 键盘录入字符串，得到该字符串字母的个数
    public static int charCount (String str){
        // 循环遍历，并统计字符串字符个数
        int count = 0; // 计数器
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' ){ // 统计大小写字母
                count++;
            }
        }
        return count; // 返回字母个数
    }

    // 调用
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // 键盘录入
        System.out.println("请输入字符串：");
        String str = scanner.next(); // 获取字符串
        System.out.println("该字符串中字母的个数为："+charCount(str));
    }

}
