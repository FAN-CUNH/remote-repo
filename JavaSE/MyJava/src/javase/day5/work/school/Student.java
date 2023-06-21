package javase.day5.work.school;

public class Student extends Person{
    // 构造方法

    public Student(String name, int age) {
        super(name, age);
    }

    public Student() {
    }

    @Override
    public void eat() {
        System.out.println("年龄为"+getAge()+"岁" +getName() +"在吃学生餐");
    }
}
