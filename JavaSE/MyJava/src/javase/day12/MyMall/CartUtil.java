package javase.day12.MyMall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CartUtil
 * @Description 购物车初始化信息以及增删改查
 * @Author Cunhao Fan
 * @Date 2023/4/21 15:04
 * @Version 1.0
 */
public class CartUtil {
    /*定义Map存放登录人和购物车的关系*/
    static Map<String, MyCart> myAndCartMap = new HashMap<String, MyCart>();
    /*定义ArrayList存放很多商品信息*/
    static ArrayList<Product> products = new ArrayList<Product>();
    /*初始化购物车*/
    Product product1 = new Product("毛巾", 18);
    Product product2 = new Product("牙刷",15);
    Product product3 = new Product("糖果",5);
    Product product4 = new Product("袜子",12);

    /*展示购物车信息*/
    public void showMyCart(String perNo) {
        /*获取购物车*/
        MyCart myCart = myAndCartMap.get(perNo);
        if (myCart == null) {
            System.out.println("没有购物车！");
        }else {
            /*获取购物项*/
            List<CartItem> cartItemList = myCart.getCartItemList();
            for (CartItem everyItem: cartItemList
                 ) {
                System.out.println(everyItem.getProductName() +" "+everyItem.getMoney()+" "+everyItem.getBuyNum() +" "+everyItem.getTotalMoney());
            }
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t"+myCart.getTotalMoney());
        }
    }

    /*将物品添加到购物车*/
    public void addInCart(Product product, String perNo){
        /*先判断有没有登录*/
        if (myAndCartMap.containsKey(perNo)){
            /*获取到登录人购物车*/
            MyCart myCart = myAndCartMap.get(perNo);
            /*获取到购物车中购物项集合*/
            ArrayList<CartItem> cartItemArrayList = (ArrayList<CartItem>) myCart.getCartItemList();
            /*判断是否存在购物项（是否买过东西） 假设没买过*/
            CartItem isBuy = null;
            for (CartItem everyItem: cartItemArrayList
                 ) {
                if (everyItem.getProductName().equals(product.getProductName())){
                    isBuy = everyItem;
                    break;
                }
            }
            if (isBuy != null){
                /*买过，则将购物项的数量+1*/
                isBuy.setBuyNum(isBuy.getBuyNum()+1);
            }else {
                /*没买过，根据商品信息生成购物项*/
                isBuy = new CartItem();
                isBuy.setProductName(product.getProductName());
                isBuy.setMoney(product.getProductPrice());
                isBuy.setBuyNum(1);
                cartItemArrayList.add(isBuy);
            }
        }else {
            /*第一次登录，创建购物项，购物项集合，购物车，再将登录人与购物车关系放入map集合中*/
            CartItem cartItem = new CartItem();
            ArrayList<CartItem> list = new ArrayList<CartItem>();
            MyCart myCart = new MyCart();
            cartItem.setProductName(product.getProductName());
            cartItem.setMoney(product.getProductPrice());
            cartItem.setBuyNum(1);
            /*将购物项添加到购物项集合*/
            list.add(cartItem);
            /*给购物车添加购物项集合*/
            myCart.setCartItemList(list);
            /*将登入人和购物车关系放入map*/
            myAndCartMap.put(perNo, myCart);
        }
    }

    /*删除购物车*/
    public void deleteMyCart(String perNo) {

    }
}
