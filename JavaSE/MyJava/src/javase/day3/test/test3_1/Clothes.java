package javase.day3.test.test3_1;

public class Clothes {
    private String color;
    private String brand;

    public Clothes(String color, String brand) {
        this.color = color;
        this.brand = brand;
    }

    public Clothes() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
