package basejava.day6.work;

public class Work10 {
    //  封装方法完成将字符串转换成int数组，并且调用
    //  原型：“12345” ====>char[]=====>将char变成int  int[] = {1,2,3,4,5};
    public static void strToInt(String str){
        char [] charArray = str.toCharArray(); // 将字符串转化成字符数组
        int [] intArray = new int[charArray.length]; // 定义一个整型数组用于存放字符转化为整型的数
        for (int i = 0; i < charArray.length ; i++) {
            char c = charArray[i];
            int cInt = Integer.parseInt(""+c); // 将字符串转化成整型
            intArray[i] = cInt; // 存入数组
        }
        for (int ele:intArray) {
            System.out.print(ele);
        }
    }

    public static void main(String[] args) {
        String str = "12345";
        Work10.strToInt(str);
        System.out.println();
        System.out.println(str.toCharArray());
    }
}
