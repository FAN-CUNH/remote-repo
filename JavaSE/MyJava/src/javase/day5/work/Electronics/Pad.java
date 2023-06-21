package javase.day5.work.Electronics;

public class Pad implements PlayGame{
    private String brand;
    private double price;

    public Pad(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public Pad() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void playGaem() {
        System.out.println("在使用"+price+"元"+brand+"平板"+"打游戏");
    }
    // 特有方法
    public void listenMusic(){
        System.out.println("在使用"+price+"元"+brand+"平板"+"听音乐");
    }
}
