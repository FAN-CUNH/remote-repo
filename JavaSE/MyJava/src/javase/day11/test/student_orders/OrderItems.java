package javase.day11.test.student_orders;

public class OrderItems {
    private String itemId;//订单项编号
    private double money;//订单项金额
    /*构造方法*/
    public OrderItems(String itemId, double money) {
        this.itemId = itemId;
        this.money = money;
    }

    public OrderItems() {
    }
    /*setget方法*/

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "itemId='" + itemId + '\'' +
                ", money=" + money +
                '}';
    }
}
