package basejava.day1.test;

public class Demo1 {
    public static void main(String[] args) { // main:程序入口
        int a = 1;
        long b = 34l;
        float f = 4.12354622222f;
        double d = 4.12354622222d;
        System.out.println("Hello World");// 打印：Hello World
        System.out.println("34"+a); // 打印341
        System.out.println("长整型:"+b); // 打印长整型：34
        System.out.println("单精度："+f); // 打印单精度：4.123546 保留小数点后六位
        System.out.println("双精度："+d); // 打印双精度：4.12354622222
    }
}
