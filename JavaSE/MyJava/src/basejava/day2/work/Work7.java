package basejava.day2.work;

import java.util.Scanner;

public class Work7 {
    public static void main(String[] args) {
        /*
        键盘录入成绩，打印等级，60以下：不及格；60-79：D   80-99:C    其他：优秀
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入成绩：："); // 输入整数
        int score = scanner.nextInt(); // 键盘获取输入值
        if (score < 60){ // 成绩小于60 不及格
            System.out.println("不及格");
        }else if(score >= 60 && score <= 79){
            System.out.println("D");
        }else if (score >= 80 && score <=90){
            System.out.println("C");
        }else {
            System.out.println("其他");
        }
    }
}
