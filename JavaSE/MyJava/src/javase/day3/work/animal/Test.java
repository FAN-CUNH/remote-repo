package javase.day3.work.animal;

public class Test {
    public static void main(String[] args) {
        Cat cat =new Cat();
        cat.name = "Tom";
        cat.name = "棕色";
        cat.eat();
        cat.catchMouse();

        Dog d = new Dog();
        d.name = "Jerry";
        d.color = "白色";
        d.eat();
        d.lookHome();
    }
}
