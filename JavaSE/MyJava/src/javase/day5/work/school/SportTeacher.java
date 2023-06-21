package javase.day5.work.school;

public class SportTeacher extends Teacher implements Sprot{ // 继承老师类，实现运动接口

    public SportTeacher(String name, int age) {
        super(name, age);
    }

    public SportTeacher() {
    }

    @Override
    public void playBasketball() {
        System.out.println("年龄为"+getAge()+"的"+getName()+"老师正在打篮球");
    }
}
