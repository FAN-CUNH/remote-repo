package javase.day3.work.sellphone;


public class Phone {
    // 属性
    private String brand; // 品牌
    private int price; // 价格

    // 构造方法
    public Phone() {
    }

    public Phone(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }


    // setget

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
    @Override
    public String toString() {
        return "价值"+price+"的"+this.brand+"手机!!!";
    }
}
