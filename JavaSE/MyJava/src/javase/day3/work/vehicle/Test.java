package javase.day3.work.vehicle;

public class Test {
    public static void main(String[] args) {
        // 实例化类对象
        Car car = new Car(4,"白色");
        car.run();
        car.addGasoline();
        ElectricBicycle electricBicycle = new ElectricBicycle(2,"黑色");
        electricBicycle.run();
        electricBicycle.charge();

    }
}
