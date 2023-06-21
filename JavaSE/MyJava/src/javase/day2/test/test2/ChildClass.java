package javase.day2.test.test2;

public class ChildClass extends ParentClass{
    // 行为

    public ChildClass(String name) {
        super(name);
    }
    // 重写方法
    @Override
    public void test() {
        System.out.println("父类的name"+super.name);
    }
}
