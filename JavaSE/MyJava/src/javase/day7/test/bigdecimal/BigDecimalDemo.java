package javase.day7.test.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName BigDecimalDemo
 * @Description 将基本数据类型转成对象 将对象转成基本数据类型
 * @Author Cunhao Fan
 * @Date 2023/4/14 14:34
 * @Version 1.0
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("2.34566");
        System.out.println(bigDecimal);
        /*四舍五入*/
        bigDecimal =  bigDecimal.setScale(4, RoundingMode.UP);
        System.out.println(bigDecimal);

        double value = bigDecimal.doubleValue();
        System.out.println("基本数据类型："+value);
    }

}
