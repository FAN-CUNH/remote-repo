package javase.day18.dynamicproxy;

/**
 * @ClassName Calculator
 * @Description 编写目标类 必须有父类接口
 * @Author Cunhao Fan
 * @Date 2023/4/27 19:37
 * @Version 1.0
 */
/*目标类的父类接口*/
interface CalculatorParent {
    public int add(int a, int b);
    public int subtract(int a, int b);
    public int multiply(int a, int b);
    public int division(int a, int b);
}
/*目标类，实现父类接口的所有方法*/
public class Calculator implements CalculatorParent{
    @Override
    public int add(int a, int b) {
        int result = a + b;
        System.out.println(result);
        return result;
    }
    public int subtract (int a, int b) {
        int result =  a - b;
        System.out.println(result);
        return result;
    }
    public int  multiply (int a, int b) {
        int result =  a * b;
        System.out.println(result);
        return result;
    }
    public int division (int a, int b) {
        int result =  a / b;
        System.out.println(result);
        return result;
    }
}
