package basejava.day3.work;

import java.util.Scanner;

public class Work3 {
    public static void main(String[] args) {
        // 键盘录入1-7数字，使用switch分支语句实现打印星期几，例如输入1打印星期一
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字“1-7：");
        int num = scanner.nextInt(); // 获取数字
        switch (num){
            case 1:{
                System.out.println("星期一");
                break;
            }
            case 2:{
                System.out.println("星期二");
                break;
            }
            case 3:{
                System.out.println("星期三");
                break;
            }
            case 4:{
                System.out.println("星期四");
                break;
            }
            case 5:{
                System.out.println("星期五");
                break;
            }
            case 6:{
                System.out.println("星期六");
                break;
            }
            case 7:{
                System.out.println("星期日");
                break;
            }
            default:{
                System.out.println("你的输入有误！！！");
            }

        }

    }
}
