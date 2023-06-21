package javase.day6.work;

import java.util.Scanner;

/**
 * @ClassName Work1
 * @Description 键盘录入数字字符串，删除字符5之后的任意字符，如果5是最后一个字符则不用删除
 * @Author Cunhao Fan
 * @Date 2023/4/13 15:19
 * @Version 1.0
 */
public class StringBufferDeleteCharAt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一串字符串：");
        String str = scanner.next();
        /*将str转化成字符串缓冲区*/
        StringBuffer stringBuffer = new StringBuffer(str);
        /*循环判断当前字符是不是5*/
        for (int i = 0; i < stringBuffer.length()-1; i++) {
            /*声明一个index存储字符5的下标*/
            char c = stringBuffer.charAt(i);
            if (c == '5'){
                /*判断当前字符是不是倒数第二位，并且最后一位是不是5*/
                if (i == stringBuffer.length()-2){
                    if (stringBuffer.charAt(i+1) != '5'){
                        stringBuffer.deleteCharAt(i+1);
                        continue;
                    }
                    else{
                        continue;
                    }
                }
                stringBuffer.deleteCharAt(i+1);
            }
        }
        System.out.println(stringBuffer);
    }

}
