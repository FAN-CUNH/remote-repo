package javase.day3.work.orders;

public class OrdersMainApp {
    public static void main(String[] args) {
        // 实例化订单项对象
        OrderItem orderItem1 = new OrderItem("电脑","000001");
        OrderItem orderItem2 = new OrderItem("键盘","000002");
        OrderItem orderItem3 = new OrderItem("鼠标","00000003");
        // 实例化订单对象
        Orders orders1 = new Orders();
        Orders orders2 = new Orders();

        // 1 添加3个订单项到第一张订单
        orders1.addOrderItem(orderItem1);
        orders1.addOrderItem(orderItem2);
        orders1.addOrderItem(orderItem3);
        System.out.println("订单1:"+orders1);

        // 2 添加2个订单项到第二张订单
        orders2.addOrderItem(orderItem1);
        orders2.addOrderItem(orderItem2);
        System.out.println("订单2:"+orders2);

        // 3将第二张订单里面订单项信息的名称打印出来
        orders1.delOrderItemMess1();
        System.out.println("执行删除项目编号长度等于的6订单项:"+orders1);
        orders2.delOrderItemMess2(orderItem2);
        System.out.println("执行删除项目编号为000002的订单项:"+orders2);
    }
}
