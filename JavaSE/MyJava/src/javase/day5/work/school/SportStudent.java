package javase.day5.work.school;

public class SportStudent extends Student implements Sprot{
    public SportStudent(String name, int age) {
        super(name, age);
    }

    public SportStudent() {
    }

    @Override
    public void playBasketball() {
        System.out.println("年龄为"+getAge()+"的"+getName()+"学生正在打篮球");
    }
}
