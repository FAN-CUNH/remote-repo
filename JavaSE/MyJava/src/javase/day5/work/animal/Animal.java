package javase.day5.work.animal;

public abstract class Animal {
    // 成员变量
    private String color;
    private int age;
    // 抽象方法
    public abstract void eat();

    public Animal(String color, int age) {
        this.color = color;
        this.age = age;
    }

    public Animal() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
