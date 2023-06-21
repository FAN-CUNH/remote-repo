package javase.day7.work;

import java.util.Scanner;

/**
 * @ClassName RegexWork
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/14 19:11
 * @Version 1.0
 */
public class RegexWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*键盘录入学生学号，要求学号中只要包含数字就可以，否则重新输入*/
        while (true){
            System.out.println("请输入学生学号：");
            String name = scanner.next();
            String regex = "[0-9]+";
            if (name.matches(regex))
                break;
        }
        /*键盘录入学生密码，要求密码必须是纯数字6位，否则重新输入*/
        while (true){
            System.out.println("请输入学生密码：");
            String name = scanner.next();
            String regex = "[0-9]{6}";
            if (name.matches(regex))
                break;
        }
        /*键盘录入学生姓名，要求只能由数字字母,_组成，否则重新输入*/
        while (true){
            System.out.println("请输入学生姓名：");
            String name = scanner.next();
            /* (\\w+)等价[0-9a-zA-Z]+ */
            String regex = "(\\w+)";
            if (name.matches(regex))
                break;
        }
        /*键盘录入学生年龄，要求只能是2位-3位之间的纯数字，否则重新输入*/
        while (true){
            System.out.println("请输入学生年龄：");
            String name = scanner.next();
            String regex = "[0-9]{2,3}";
            if (name.matches(regex))
                break;
        }
    }
}
