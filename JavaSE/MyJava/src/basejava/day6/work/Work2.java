package basejava.day6.work;

public class Work2 {
    // 打印5位数中所有的回文数
    // 创建isPalinNum
    public static void isPalin(){
        // 循环打印
        for (int i = 10000; i < 100000; i++) {
            // 判断是否是回文数
            //如果第一位和最后一位并且第二位和倒数第二位相等则是回文数
            if ((""+i).charAt(0)== (""+i).charAt((""+i).length()-1) && (""+i).charAt(1) == (""+i).charAt((""+i).length()-2)){
                System.out.print(i+" ");
            }
        }
    }

    public static void isPalinPlus(){
        // 循环打印
        for (int i = 10000; i < 100000; i++) {
            // 判断是否是回文数
            //如果第一位和最后一位并且第二位和倒数第二位相等则是回文数
            if ((""+i).startsWith((""+i).substring(0,2)) == (""+i).endsWith(""+(""+i).charAt(1)+(""+i).charAt(0))){
                // 注意字符串.startsWith()/字符串.endsWith()括号中必须是字符串形式
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) {
        isPalin();
        System.out.println();
        isPalinPlus();
    }
}
