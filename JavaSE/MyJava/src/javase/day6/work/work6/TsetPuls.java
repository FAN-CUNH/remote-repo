package javase.day6.work.work6;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName TsetPuls
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/14 10:44
 * @Version 1.0
 */
public class TsetPuls {
    public static void main(String[] args) throws ParseException {
        Verification verification = new Verification();
        //测试Person实例化
        Scanner scanner =new Scanner(System.in);
        while (true){
            System.out.println("请录入用户名：");
            String name = scanner.next();
            System.out.println("请录入身份证号：");
            String personId= scanner.next();
            System.out.println("请录入出生日期(以yyyy-MM-dd形式输入)：");
            String birthday = scanner.next();
            System.out.println("请录入请录入性别：");
            String sex = scanner.next();
            boolean isName = verification.isNameRight(name);
            boolean isPersonId = verification.isPersonIdRight(personId);
            Date isBirthday = verification.isBirthdayRight(birthday);
            Sex isSex = verification.isSexRight(sex);
            if(isName && isBirthday!=null && isPersonId && isSex != null){
                Person person = new Person(name,personId,isBirthday,isSex);
                System.out.println(person);
                break;
            }
        }
    }
}
