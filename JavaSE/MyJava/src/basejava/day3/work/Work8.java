package basejava.day3.work;

import java.util.Random;

public class Work8 {
    public static void main(String[] args) {
        // 随机产生10个随机数（100以内）放置到数组：选做
        Random random = new Random();
        int j = 0;
        int [] arr = new int[10]; // 申请存储空间
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(100); // 100以内的随机数
            // System.out.print(num+" ");
            arr[j] = num; // 将随机数存入数组
            System.out.print(arr[j]+" ");
        }
    }
}
