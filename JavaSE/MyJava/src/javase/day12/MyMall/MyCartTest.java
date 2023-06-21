package javase.day12.MyMall;

/**
 * @ClassName MyCartTest
 * @Description 测试
 * @Author Cunhao Fan
 * @Date 2023/4/21 15:07
 * @Version 1.0
 */
public class MyCartTest {
    public static void main(String[] args) {
        CartUtil cartUtil = new CartUtil();
        cartUtil.showMyCart("001");
        Product product = new Product("毛巾",20);
        cartUtil.addInCart(product,"001");
        cartUtil.addInCart(product,"001");
        cartUtil.showMyCart("001");
    }
}
