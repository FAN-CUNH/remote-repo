package javase.day3.work.animal;

public class Cat extends Animal{
    public Cat(String name, String color) {
        super(name, color);
    }

    public Cat() {
    }

    public void catchMouse(){
        System.out.println(this.color+"的"+name+"正在抓老鼠!!!");
    }
}
