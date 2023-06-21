package javase.day4.work.work1;

public class Test {
    public static void main(String[] args) {
        A a = new B(); // 子类实例化
        a.out();
        a.out1();

        A a1 = new A() { // 匿名内部类
            @Override
            public void out() {
                System.out.println("我是子类实现的out");
            }

            @Override
            public void out1() {
                System.out.println("我是子类实现的out1");
            }
        };
        a1.out();
        a1.out1();
    }
}
