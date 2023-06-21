package javase.day14.work.work1;

/**
 * @ClassName Test
 * @Description 定义一个函数式泛型接口MyInterface,抽象方法:printShu接收泛型值；没有返回值；最后通过Lambda完成接口的实例化以及方法的调用
 * @Author Cunhao Fan
 * @Date 2023/4/23 13:43
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String str = "123";
        MyInterface myInterface = System.out::print;
        myInterface.printNum(str);
    }
}
