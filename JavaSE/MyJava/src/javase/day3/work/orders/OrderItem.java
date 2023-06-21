package javase.day3.work.orders;

public class OrderItem { // 订单项
    // 声明两个私有成员变量
    private String orderItemName; // 订单名
    private String orderItemId; // 订单号

    // setget方法

    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }


    // 构造方法


    public OrderItem(String orderItemName, String orderItemId) {
        this.orderItemName = orderItemName;
        this.orderItemId = orderItemId;
    }

    public OrderItem() {
    }

    // 重写toString

    @Override
    public String toString() {
        return "{" +
                "订单名:" + orderItemName +
                ", 订单号:" + orderItemId +
                '}';
    }
}
