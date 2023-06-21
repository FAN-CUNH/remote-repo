package javase.day5.work.animal;

public class Tiger extends Animal{
    public Tiger(String color, int age) {
        super(color, age);
    }

    public Tiger() {
    }

    @Override
    public void eat() {
        System.out.println(getAge()+"岁的"+getColor()+"老虎吃肉");
    }
}
