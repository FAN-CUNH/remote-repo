package javase.day5.work.school;

public class Teacher extends Person{
    // 构造方法

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher() {
    }
    // 实现抽象吃的行为
    @Override
    public void eat() {
        System.out.println("年龄为"+getAge()+"的"+getName()+"老师"+",正在吃工作餐");
    }
}
