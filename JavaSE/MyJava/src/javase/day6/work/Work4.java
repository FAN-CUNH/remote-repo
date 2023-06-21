package javase.day6.work;

import java.util.Scanner;

/**
 * @ClassName Work4
 * @Description 键盘录入用户名，必须以英文开头,只能包含英文,数字和_;最少6位,做多12位
 * @Author Cunhao Fan
 * @Date 2023/4/13 18:26
 * @Version 1.0
 */
public class Work4 {
    /*isConform判断当前字符串的长度是否大于6小于12*/
    public boolean isConform (String str){
        return (str.length() > 6 && str.length() <12);
    }
    /*isBegin判断当前字符串是否已英文开头*/
    public boolean isBegin (String str){
        return (str.charAt(0) >='a' && str.charAt(0) <= 'z' || str.charAt(0) >= 'A' && str.charAt(0) <= 'Z');
    }
    /*isChar判断其是否是纯字母*/
    boolean isChar = true;
    public boolean isChar (String str){
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')){
                isChar = false;
                break;
            }
        }
        return isChar;
    }
    /*isNumber判断其是否是纯数字*/
    /*
    boolean isNumber = true;
    public boolean isNumber (String str){
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')){
                isNumber = false;
                break;
            }
        }
        return isNumber;
    }*/
    /*isChar判断当前字符串是否出现其他字符*/
    boolean hasOtherChar = true;
    public boolean hasOtherChar(String str){
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '_' && !(str.charAt(i) >= '0' && str.charAt(i) <= '9') && !(str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') ){
                hasOtherChar = false;
                break;
            }
        }
        return hasOtherChar;
    }
    public static void main(String[] args) {
        Work4 work4 = new Work4();
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入用户名(必须以英文开头,只能包含英文,数字和_，最少6位,做多12位)：");
        String str = scanner.next();
        if (work4.isConform(str) && work4.isBegin(str) && work4.hasOtherChar(str)){
            System.out.println(str);
        }else {
            System.out.println("输入有误！！！");
        }
    }
}
