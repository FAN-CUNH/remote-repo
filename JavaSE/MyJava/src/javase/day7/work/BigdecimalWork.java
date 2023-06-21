package javase.day7.work;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @ClassName Bigdecimal
 * @Description 对于键盘录入的字符串纯数字，要求将其修改成小数位数不超过4位的纯数字字符串，
 *              如果超过了那么使用四舍五入取舍
 * @Author Cunhao Fan
 * @Date 2023/4/14 16:36
 * @Version 1.0
 */
public class BigdecimalWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = scanner.next();
        /*正则表达式判断其是否为纯数字*/
        String regex = "[0-9]+[.]*[0-9]*";
        boolean isRight = str.matches(regex);
        System.out.println(isRight);
        if (isRight){
            BigDecimal bigDecimal1 = new BigDecimal(str);
            BigDecimal bigDecimal2 = new BigDecimal(str);
            /*RoundingMode.HALF_UP保留部分后一位大于等于0.5进位，否则舍去*/
            bigDecimal1 = bigDecimal1.setScale(4, RoundingMode.UP);
            /*标准四舍五入RoundingMode.HALF_UP*/
            bigDecimal2 = bigDecimal2.setScale(4, RoundingMode.HALF_UP);
            System.out.println(bigDecimal1);
            System.out.println(bigDecimal2);
            System.out.println(bigDecimal1.doubleValue());
            System.out.println(bigDecimal2.doubleValue());
        }

    }
}
