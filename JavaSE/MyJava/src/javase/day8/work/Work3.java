package javase.day8.work;

import java.util.Scanner;

/**
 * @ClassName Work3
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/15 11:46
 * @Version 1.0
 */
public class Work3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请录入字符串：");
        String str = scanner.next();
        Work2 work2 = null;
        try {
            work2 = new Work2();
            if (!(str.equals("0") || str.equals("1"))){
                throw work2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
