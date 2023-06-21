package javase.day6.test.test4;

import java.util.Scanner;

public class Test4 {
    /*isAllNum方法：判断接收过来的字符串全是数字，假设全是数组，若找到一个不是数字则跳出循环，并返回修改后的标记值*/
    public boolean isAllNum (String string){
        boolean isAllNumber = true;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (!(c >= '0' && c <= '9')){
                isAllNumber = false;
                break;
            }
        }
        return isAllNumber;
    }

    public static void main(String[] args) {
        /*实例化Test4对象，用于调用其中的isAllNum方法*/
        Test4 test4 = new Test4();
        /*实例化Scanner对象，用于接接收键盘录入的信息*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字字符串：");
        String string = scanner.nextLine();
        /*实例化StringBuffer对象,用于存放和修改string的值*/
        StringBuffer stringBuffer = new StringBuffer(string);
        if (test4.isAllNum(string)){
            /*先取到每个字符，然后将字符转换成数字进行+1操作后再将其加到当前个字符后（stringbBuffer.insert(index,value)），
            然后将循环指针+1，当执行到字符串最后一位时，用stringBuffer.append在其后追加，然后结束循环*/
            for (int i = 0; i < stringBuffer.length(); i++) {
                int c = Integer.parseInt(stringBuffer.charAt(i)+"");
                if (i == stringBuffer.length()-1){
                    stringBuffer.append(c+1);
                    break;
                }
                else {
                    /*如果当前数字是9，则在执行+1操作插入后，应让指针往后跳两位（10-->两个字符）*/
                    if (c == 9){
                        stringBuffer.insert(i+1,c+1+"");
                        i+=2;
                    }else {
                        stringBuffer.insert(i+1,c+1+"");
                        i++;
                    }
                }
            }
        }
        else {
            System.out.println("输入有误");
        }
        System.out.println(stringBuffer.toString());
    }
}
