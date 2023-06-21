package javase.day5.work.animal;

public class Parrot extends Animal{
    public Parrot(String color, int age) {
        super(color, age);
    }

    public Parrot() {
    }

    // 特有方法
    public void say(){
        System.out.println(getAge()+"岁的"+getColor()+"i.鹦鹉在说你好");
    }

    @Override
    public void eat() {
        System.out.println(getAge()+"岁的"+getColor()+"鹦鹉在吃小米");
    }
}
