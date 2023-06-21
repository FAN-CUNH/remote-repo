package javase.day3.work.vehicle;

public class Vehicle {
    int wheel;
    String color;

    public Vehicle(int wheel, String color) {
        this.wheel = wheel;
        this.color = color;
    }

    public Vehicle() {
    }

    public void run(){
        System.out.println(wheel+"个轮子的"+color+"小汽车在跑!!!");
    }
}
