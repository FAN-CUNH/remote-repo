package javase.day12.MyMall;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Cart
 * @Description 购物车存放购物项，以及购物总金额
 * @Author Cunhao Fan
 * @Date 2023/4/21 15:01
 * @Version 1.0
 */
public class MyCart {
    /*成员变量*/
    private List<CartItem> cartItemList = new ArrayList<CartItem>(); //购物项
    private double totalMoney; // 总金额
    /*构造方法*/

    public MyCart(List<CartItem> cartItemList, double totalMoney) {
        this.cartItemList = cartItemList;
        this.totalMoney = totalMoney;
    }

    public MyCart() {
    }
    /*setget方法*/

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public double getTotalMoney() {
        for (CartItem everyCartItem:cartItemList) {
            totalMoney = totalMoney + everyCartItem.getTotalMoney();
        }
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
