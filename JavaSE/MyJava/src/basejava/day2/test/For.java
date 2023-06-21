package basejava.day2.test;

import java.util.Scanner;

public class For {
    public static void main(String[] args) {
        // 打印1-100以内的所有偶数和奇数
        for (int i =1 ;i <= 100;i+=2){
            System.out.print("奇数："+i+" ");
        }
        System.out.println();
        // 判断某个数是素数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = scanner.nextInt();
        int i;
        for (i = 2; i < num; i++) {
            if(num % i == 0)  // 若这个数能被2-它自身的数整除 则跳出循环
                break; // 跳出for循环
        }
        if (i < num){ // 若i比这个数小，则说明这个数被它的因数整除了，即不是素数。反之，为素数
            System.out.println(num+"不是素数");
        }
        else
            System.out.println(num+"是素数");
        }
    }
