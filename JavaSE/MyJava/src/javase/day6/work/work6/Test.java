package javase.day6.work.work6;/*
package JavaSE.day6.work.work6;

import sun.font.DelegatingShape;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

*/
/**
 * @ClassName Test
 * @Description name不能出现数字，personID只能是数字或者字母，birthday出生年月不能超过系统时间同时要符合日期格式（只要求输入年月日即可），性别输入0表示男生，1表示女生输入其他不可以
 * @Author Cunhao Fan
 * @Date 2023/4/13 19:18
 * @Version 1.0
 *//*

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        Scanner scanner =new Scanner(System.in);

        */
/*姓名*//*

        while(true){
            System.out.println("请输入姓名：");
            boolean isAllChar = true;
            String name = scanner.next();
            for (int i = 0; i < name.length(); i++) {
                if ((name.charAt(i) >= '0' && name.charAt(i) <= '9')){
                    System.out.println("姓名输入有误");
                    isAllChar = false;
                    break;
                }
            }
            if (isAllChar){
                person.setName(name);
                break;
            }

        }
        */
/*身份证*//*

        while (true){
            System.out.println("请输入身份证号：");
            String personId = scanner.next();
            boolean isSuccess = true;
            for (int i = 0; i < personId.length(); i++) {
                if (!(personId.charAt(i) >= '0' && personId.charAt(i) <= '9') && !(personId.charAt(i) >= 'a' && personId.charAt(i) <= 'z') && !(personId.charAt(i) >= 'A' && personId.charAt(i) <= 'Z')){
                    isSuccess =false;
                    System.out.println("身份证号输入有误");
                }
            }
            if (isSuccess){
                person.setPersonId(personId);
                break;
            }
        }
        */
/*生日*//*

        while(true){
            System.out.println("请输入出生年份：");
            int year = scanner.nextInt();
            System.out.println("请输入出生月份：");
            int month = scanner.nextInt();
            System.out.println("请输入出生日：");
            int day = scanner.nextInt();
            LocalDate localDate = LocalDate.of(year,month,day);
            boolean isSuccess1 = true;
            if (year > LocalDate.now().getYear()){
                isSuccess1 = false;
            }
            if (isSuccess1){
            person.setBirthday(localDate);
            break;
            }
        }
        */
/*性别*//*

        while (true){
            boolean isSuccess = true;
            System.out.println("请输入性别（0 男 ， 1 女）");
            int sex = scanner.nextInt();
            if (sex == 0){
                Sex sex1 = Sex.BOY;
                person.setSex(sex1);

            }else if(sex == 1){
                Sex sex1 = Sex.GIRl;
                person.setSex(sex1);
            }else{
                isSuccess =false;
            }
            if (isSuccess){
                break;
            }
        }

        System.out.println(person);
    }

}
*/
