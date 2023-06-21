package javase.day1.work3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        // 实例化学生对象
        Student myStu1 = new Student();
        Scanner scanner = new Scanner(System.in); // 获取键盘录入
        System.out.println("请输入学员编号：");
        String stuNo = scanner.next(); // 创建局部变量存储学生的属性
        myStu1.setStuNo(stuNo);
        System.out.println("请输入学员姓名：");
        String stuName = scanner.next();
        myStu1.setStuName(stuName);
        System.out.println("请输入学员性别：");
        String stuSex = scanner.next();
        myStu1.setStuSex(stuSex);
        System.out.println("请输入学员身高：");
        double stuHight = scanner.nextDouble();
        myStu1.setStuHight(stuHight);
        System.out.println("请输入学员年龄：");
        int stuAge = scanner.nextInt();
        myStu1.setStuAge(stuAge);

        System.out.println(myStu1.getStuNo()+" "+myStu1.getStuName()+" "+myStu1.getStuSex()+" "+myStu1.getStuHight()+" "+myStu1.getStuAge());

    }
}
