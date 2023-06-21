package javase.day6.test.test3;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        /*
        键盘录入数值字符串，判断改数值字符串是否是正过来和反过来都是一样的
        如果不输入纯数字那么就让其一直输入下去
        */

        /*实例化Test3类，调用isAllNum方法*/
        Test3 test3 = new Test3();
        Scanner scanner = new Scanner(System.in);
        while (true){
        /*先实例化Scanner，在获取到键盘录入的信息，判断其是否是纯数字，若不是则重复输入操作*/
            System.out.println("请输入纯数字字符串：");
            String str = scanner.nextLine();
            boolean isAllNumber = test3.isAllNum(str);
            if (isAllNumber){
                /*实例化字符串缓冲区，将str转换成字符串缓冲区*/
                StringBuffer stringBuffer = new StringBuffer(str);
                System.out.println(str.equals(stringBuffer.reverse().toString())?"回文":"不是");
                break;
            }
        }
    }
    /*isAllNum方法：假设字符串中全是数字，验证：循环获取到的字符串中的每个字符拿出来，判断其是否是数字，若不是数字修改isAllNum值且则跳出循环，返回isAllNum值*/
    public boolean isAllNum(String string){
        boolean isAllAnum = true;
        for (int i = 0; i < string.length(); i++) {
            int c = string.charAt(i);
            if (!(c >= '0' && c <= '9')){
                isAllAnum = false;
                break;
            }
        }
        return isAllAnum;
    }
}
