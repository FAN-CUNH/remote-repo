package javase.day12.MyMall;

/**
 * @ClassName Product
 * @Description 各种商品模板类
 * @Author Cunhao Fan
 * @Date 2023/4/21 15:03
 * @Version 1.0
 */
public class Product {
    /*成员变量*/
    private String productName;
    private double productPrice;
    /*构造方法*/
    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }
    public Product() {
    }
    /*setget方法*/
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    /*重写toString*/

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
