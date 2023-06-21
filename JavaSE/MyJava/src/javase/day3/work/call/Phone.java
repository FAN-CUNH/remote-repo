package javase.day3.work.call;

public class Phone {
    // 属性
    private String brand; // 品牌
    private int price;

    public Phone(String brand, int price) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // 打电话方法
    public String call(String name){
        return "给"+name+"打电话!!!";
    }
}
