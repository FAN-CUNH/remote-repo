package javase.day3.work.vehicle;

public class ElectricBicycle extends Vehicle{
    public ElectricBicycle(int wheel, String color) {
        super(wheel, color);
    }

    public ElectricBicycle() {
    }

    public void charge(){
        System.out.println(wheel+"个轮子的"+color+"电动车充电!!!");
    }
}
