package javase.day7.work;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName BigItegerWork
 * @Description 键盘录入纯数字字符串，输入负数，那么将负数对应的值-1再输出；输入正数，就直接对其+1输出
 * @Author Cunhao Fan
 * @Date 2023/4/14 17:47
 * @Version 1.0
 */
public class BigItegerWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入纯数字字符串：");
        String str = scanner.next();
        /*正则表达式判断当前字符串是否是纯数字字符串*/
        String regex = "-*[+]*[0-9]+";
        boolean isRight = str.matches(regex);
        if (isRight){
            /*是纯数字，判断其是整数还是负数*/
            /*普通方法*/
            /*int strNumber = Integer.parseInt(str);
            if (strNumber > 0){
                strNumber = strNumber + 1;
                System.out.println(strNumber);
            }else if (strNumber < 0){
                strNumber = strNumber - 1;
                System.out.println(strNumber);
            }*/
            /*BigInteger方法*/
            BigInteger bigInteger = new BigInteger(str);
            if (bigInteger.intValue() > 0){
                System.out.println(bigInteger.intValue()+1);
            }else {
                bigInteger = bigInteger.abs();
                int strNumber = bigInteger.intValue()+1;
                strNumber = Integer.parseInt(""+"-"+strNumber);
                System.out.println(strNumber);
            }

        }
    }
}
