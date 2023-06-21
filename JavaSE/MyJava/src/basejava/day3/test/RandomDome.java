package basejava.day3.test;

import java.util.Random;

public class RandomDome {
    public static void main(String[] args) {
        // 适用Random产生随机数
        // Random 变量名 = new Random;
        Random random = new Random();
        double num1 = random.nextDouble();
        int num2 = random.nextInt(100);
        System.out.println("随机数1为："+num1);
        System.out.println("随机数2为："+num2);
    }
}
