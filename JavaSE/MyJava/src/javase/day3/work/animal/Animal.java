package javase.day3.work.animal;

public class Animal {
    String name;
    String color;

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Animal() {
    }


    // 吃
    public void eat(){
        System.out.println(color+"的"+name+"在吃东西!!!");
    }
}
