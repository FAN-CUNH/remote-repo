package javase.day6.work;

import java.util.Scanner;

/**
 * @ClassName StringBufferAppend
 * @Description 键盘录入数字字符串，将数字字符串拼接其位数的整型数值打印出来(假设字符串拼接后结果不超出整型范围)
 * @Author Cunhao Fan
 * @Date 2023/4/13 16:49
 * @Version 1.0
 */
public class StringBufferAppend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字字符串：");
        String str = scanner.next();
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(stringBuffer.length());
        System.out.println(stringBuffer);
    }
}
