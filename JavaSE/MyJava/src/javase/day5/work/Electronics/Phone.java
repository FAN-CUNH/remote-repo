package javase.day5.work.Electronics;

public class Phone {
    private String brand;
    private double price;

    public Phone(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public Phone() {
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

    // 自定义行为
    public void call (String name){
        System.out.println("在使用"+price+"元"+brand+"手机给"+name+"打电话");
    }
    public void sendMessage (String name){
        System.out.println("在使用"+price+"元"+brand+"手机给"+name+"发信息");
    }
}
