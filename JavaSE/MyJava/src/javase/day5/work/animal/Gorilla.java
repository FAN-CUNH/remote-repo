package javase.day5.work.animal;

public class Gorilla extends Animal{
    public Gorilla(String color, int age) {
        super(color, age);
    }

    public Gorilla() {
    }

    @Override
    public void eat() {
        System.out.println(getAge()+"岁的"+getColor()+"大猩猩吃香蕉");
    }
}
