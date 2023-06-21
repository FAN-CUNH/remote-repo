package javase.day3.work.orders;

import java.util.Arrays;

public class Orders { // 订单
    // 一个订单包含6个订单项
    // 成员变量存储订单项对象，数组的类型是类
    private OrderItem [] orderItems; // 声明一个OrderItem类型数组]
    private int orderItemCount = 0; // 当前项目计数

    // setget方法

    public OrderItem[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItem[] orderItems) {
        this.orderItems = orderItems;
    }

    public int getOrderItemCount() {
        return orderItemCount;
    }

    public void setOrderItemCount(int orderItemCount) {
        this.orderItemCount = orderItemCount;
    }


    // 构造方法

    public Orders() {
        orderItems = new OrderItem[6];
    }

    public Orders(OrderItem[] orderItems) {
        this.orderItems = new OrderItem[6];
    }

    // 重写tostring方法
    @Override
    public String toString() {
        return  Arrays.toString(orderItems) ;
    }

    // 添加订单项操作，如果订单项号中的长度大于20，并且包含字母不允许存入
    public void addOrderItem(OrderItem orderItem){
        String orderItemId = orderItem.getOrderItemId(); // 获取当前订单项对象的id
        // 判断当前订单项id中是否包含字母
        boolean isExistLetter = false; // 假设没有字母
        for (int i = 0; i < orderItemId.length(); i++) { //  验证假设
            // 获取当前订单项id的每个字符
            char c = orderItemId.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
                isExistLetter = true; // 假设不成立
                break;
            }
        }

        if (orderItemId.length() > 20 && isExistLetter){
            System.out.println("订单项编号不符合，不予添加!!!");
        }
        else {
            // 将对象存入数组
            orderItems[this.orderItemCount] = orderItem;
            this.orderItemCount++; // 每存入一个对象，将数组下标后移
        }
    }

    //  删除订单操作 删除订单项编号长度是6的订单信息
    public void delOrderItemMess1(){ // 订单项编号长度为6的都删除，不用传参
        for (int i = 0; i < this.orderItemCount; i++) {
            // 定义局部变量，获取数组对象的编号属性
            // System.out.println("每个订单项："+orderItems[i]);
            if (orderItems[i] != null){ // 判断当前对象是否为null
                String orderItemId = orderItems[i].getOrderItemId();
                //System.out.println(orderItemId);此次循环是的id值
                if (orderItemId.length() == 6){
                    // 删除订单项  前移+补位
                    for (int j = i; j < orderItemCount-1; j++) {
                        orderItems[j] = orderItems [j+1]; // 前移
                    }
                    orderItems[this.orderItemCount-1] = null; // 补位
                    i--; // 防止连续的长度为6的漏删
                }
            }
        }
    }

    // 删除订单项编号为0000002的订单项
    public void delOrderItemMess2(OrderItem orderItem){
        // 获取当前对象的订单项编号
        if (orderItem != null){
            String orderItemId = orderItem.getOrderItemId();
            for (int i = 0; i < this.orderItemCount; i++) {
                if (orderItems[i] != null && orderItems[i].getOrderItemId().equals(orderItemId)){
                    for (int j = i; j < orderItemCount-1; j++) {
                        orderItems[j] = orderItems [j+1]; // 前移
                    }
                    orderItems[this.orderItemCount-1] = null; // 补位
                    i--; // 防止连续的长度为6的漏删
                }
            }
        }

    }
}
