package javase.day3.work.animal;

public class Dog extends Animal{
    public Dog(String name, String color) {
        super(name, color);
    }

    public Dog() {
    }


    public void lookHome(){
        System.out.println(this.color+"的"+this.name+"狗在看家!!!");
    }
}
