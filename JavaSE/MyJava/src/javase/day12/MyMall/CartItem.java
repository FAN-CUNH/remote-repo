package javase.day12.MyMall;

/**
 * @ClassName CartItem
 * @Description 购物项 存放具体购物信息（商品名、价格、小计）
 * @Author Cunhao Fan
 * @Date 2023/4/21 15:06
 * @Version 1.0
 */
public class CartItem {
    private String productName;
    private double money; //每件商品的价格
    private int buyNum; //购买数量
    private double totalMoney; //小计 = 商品价格*购买数量计算出来的
    /*构造方法*/

    public CartItem(String productName, double money, int buyNum, double totalMoney) {
        this.productName = productName;
        this.money = money;
        this.buyNum = buyNum;
        this.totalMoney = totalMoney;
    }

    public CartItem() {
    }

    /*setget方法*/
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public double getTotalMoney() {
        return totalMoney = money * buyNum;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
