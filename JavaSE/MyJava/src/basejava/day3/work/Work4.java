package basejava.day3.work;

import java.util.Random;

public class Work4 {
    public static void main(String[] args) {
        // 通过Random产生随机数，判断该随机数是否既是偶数也是素数，如果是打印万事大吉，否则打印效果不佳
        Random random = new Random();
        int num = random.nextInt(10); // 10以内的随机数
        System.out.println(num);
        boolean flag1 = false,flag2 = false; // 偶数，素数标记

        if (num % 2 == 0) { // 是偶数 标记
            flag1 = true;
        }
        if (num == 2)   // 2是素数
            flag2 = true;
        else {
            for (int i = 2; i < num; i++) { // 判断是否是素数
                if (num % i == 0)
                    break;
                if (!(i < num)){
                    flag2 = true;
                }
            }
        }

        if (flag1 && flag2){ // 既是偶数又是素数
            System.out.println("万事大吉");
        }
        else {
            System.out.println("效果不佳");
        }
    }
}
