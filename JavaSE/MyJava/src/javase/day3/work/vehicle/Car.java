package javase.day3.work.vehicle;

public class Car extends Vehicle{
    public Car() {
    }

    public Car(int wheel, String color) {
        super(wheel, color);
    }

    public void addGasoline(){
        System.out.println(wheel+"个轮子"+color+"的车在加油!!!");
    }
}
