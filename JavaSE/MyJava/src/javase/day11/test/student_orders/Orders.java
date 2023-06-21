package javase.day11.test.student_orders;

import java.util.Date;

public class Orders {
    private String orderId;//订单编号
    private Date orderTime;//下单时间
    /*构造方法*/

    public Orders(String orderId, Date orderTime) {
        this.orderId = orderId;
        this.orderTime = orderTime;
    }

    public Orders() {
    }
    /*setget方法*/

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId='" + orderId + '\'' +
                ", orderTime=" + orderTime +
                '}';
    }
}
