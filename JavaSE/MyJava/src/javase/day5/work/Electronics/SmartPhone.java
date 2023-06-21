package javase.day5.work.Electronics;

public class SmartPhone extends Phone implements PlayGame{
    public SmartPhone(String brand, double price) {
        super(brand, price);
    }

    public SmartPhone() {
    }

    @Override
    public void playGaem() {
        System.out.println("在使用"+getPrice()+"元"+getBrand()+"手机"+"打游戏");
    }
}
