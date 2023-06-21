package javase.day3.work.playgame;

public class Phone {
    // 声明1个私有成员属性变量
    private String brand; // 品牌

    // 构造方法

    public Phone() {
    }

    public Phone(String brand) {
        this.brand = brand;
    }

    // setget方法


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // 玩游戏
    public String playGame(){
        return "玩游戏!!!";
    }
}
