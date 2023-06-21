package javase.day6.work.work6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @ClassName Verification
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/14 10:27
 * @Version 1.0
 */
public class Verification {
    /*校验姓名*/
    public boolean isNameRight (String name){
        /*假设输入的姓名是满足条件的，如果出现除数字之外的其他字符，则将修改isPersonIdRight的值*/
        boolean isNameRight = true;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) >= '0' && name.charAt(i) <= '9'){
                System.out.println("姓名输入有误");
                isNameRight = false;
                break;
            }
        }
        return isNameRight;
    }
    /*校验身份证号*/
    public boolean isPersonIdRight (String personId){
        /*假设输入的身份证号是满足条件的，如果出现除数字字母之外的其他字符，则将修改isPersonIdRight的值*/
        boolean isPersonIdRight = true;
        for (int i = 0; i < personId.length(); i++) {
            if (!(personId.charAt(i) >= '0' && personId.charAt(i) <= '9') && !(personId.charAt(i) >= 'a' && personId.charAt(i) <= 'z') && !(personId.charAt(i) >= 'A' && personId.charAt(i) <= 'Z')){
                isPersonIdRight =false;
                System.out.println("身份证号输入有误");
            }
        }
        return isPersonIdRight;
    }
    /*校验生日*/
    public Date isBirthdayRight (String birthday) throws ParseException {
        /*正则表达式验证日期格式是否正确*/
        String regular = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$";
        if (Pattern.matches(regular,birthday)){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
            /*字符串转日期，作为返回值*/
            Date date1 = simpleDateFormat.parse(birthday);
            /*日期转字符串，用于和birthday比较大小*/
            String dateString = simpleDateFormat.format(date);
            /*result <= 0,满足出生年月不能超过系统时间*/
            int result = birthday.compareTo(dateString);
            /*满足条件，返回。否则置空*/
            if (result <= 0){
                return date1;
            }else{
                System.out.println("出生日期错误,不能超过当前时间！");
                return null;
            }
        } else {
            System.out.println("出生日期输入格式错误！");
            return null;
        }
    }

    /*校验性别*/
    public Sex isSexRight(String sex){
        if(sex.equals("0")){
            return Sex.BOY;
        }
        else if(sex.equals("1")){
            return  Sex.GIRl;
        }
        else {
            System.out.println("性别输入有误！");
            return  null;
        }
    }
}
