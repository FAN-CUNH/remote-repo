package basejava.day6.work;

import java.util.Arrays;

public class Work1 {
    // 需求1：如果一个数的平方的末尾和原数相等，那么称其为自守数
    // 比如原数是5,5 * 5=25,25的末尾5==原数5，那么该原数5就是自守数
    // 25 * 25=625，76 * 76=5776，要求寻找10000以内的自守数

    // 创建isSelf方法,循环找出所有的自守数存入数组，调用方法返回数组
    public static void isSelf (){
        for (int i = 0; i < 10000; i++) { // 10000以内
            int product = i * i; // 积
            // 找出尾数
            int tail = Integer.parseInt((""+product).substring((""+product).length()-(""+i).length(),(""+product).length())); // 尾数
            if (tail == i){
                System.out.print(i+"是自守数"+" ");
            }
        }
    }

    public static int [] isSelfPlus (){
        int selfCount = 0; // 自守数计数器
        String str = "";
        int [] isSelfNum = new int[9]; // 问题：此处数组长度不固定如何操作 先不存入数组 存入字符串以/隔开 然后再将字符串转成数组
        for (int i = 0; i < 10000; i++) { // 10000以内
            int product = i * i; // 积
            // 找出自守数
            boolean isSelf = (""+product).endsWith(""+i); // boolean isEedsWithEle = 字符串.endsWith(字符串); 判断这个子串是否是字符串的尾符
            if (isSelf){
                //isSelfNum[selfCount] = i;
                str = str + i+"/";
                selfCount++;
            }


        }
        return isSelfNum;
    }

    public static void main(String[] args) {
        isSelf();
        System.out.println();
        System.out.println("自守数有："+Arrays.toString(isSelfPlus()));
    }
}
