package javase.day7.test.biginteger;

import java.math.BigInteger;

/**
 * @ClassName BigIntegerDemo
 * @Description 将整数包装包装类的工具类
 * @Author Cunhao Fan
 * @Date 2023/4/14 16:29
 * @Version 1.0
 */
public class BigIntegerDemo {
    public static void main(String[] args) {
        int a = -3;
        BigInteger bigInteger = new BigInteger(""+a);
        /*绝对值方法*/
        bigInteger = bigInteger.abs();
        int b = bigInteger.intValue();
        System.out.println(b);
    }
}
