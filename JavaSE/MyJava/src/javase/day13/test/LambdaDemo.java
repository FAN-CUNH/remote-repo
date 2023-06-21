package javase.day13.test;

/**
 * @ClassName LambdaDemo
 * @Description 为接口完成实例化，使用条件：接口中只能有一个抽象方法（函数式接口）可以有静态和默认方法  语法 （参数名，...，参数名） -> {方法实现  return 返回值}
 * @Author Cunhao Fan
 * @Date 2023/4/21 10:03
 * @Version 1.0
 */
/*注解类 检测是否是函数接口，不是函数式接口会报错*/
@FunctionalInterface
interface A {
    public void test();
}
@FunctionalInterface
interface B {
    public void test(int a,int b);
}
@FunctionalInterface
interface C {
    public int getSum(int a,int b);
}
@FunctionalInterface
interface D {
    public int getSum(int a,int b);
}

public class LambdaDemo {
    public static void main(String[] args) {
        /*无参无返回值的接口实现方法->lambda表达式*/
        A a = () -> {};
        /*调用*/
        a.test();
        /*有参无返回值 实参不能重名,根据形参对号入座*/
        B b = (a1,b1) -> {};
        /*有参有返回值*/
        C c = Integer::sum;
        int sum= c.getSum(2,1);
        /*有参有返回值（缩写版本:方法体内有且只有一个语句，无论有无返回值都可以省略大括号和语句分号，必须省略return关键字）*/
        D d= Integer::sum;
        int sum2 = 2 + 3;
        System.out.println(sum2);
    }
}
