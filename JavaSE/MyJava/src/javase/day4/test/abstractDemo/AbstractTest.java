package javase.day4.test.abstractDemo;

public class AbstractTest {
    public static void main(String[] args) {
        // 有子类实例化
        AbstractDemo abstractDemo = new AbstractChildDemo();
        abstractDemo.out();

        // 无子类，通过匿名内部类实现
        AbstractDemo abstractDemo1 = new AbstractDemo() {
            @Override
            public void out() {
                System.out.println("我是子类的实现");
            }
        }; // 此处必须加分号，否则报错
    }
}
