package javase.day11.test.student_orders;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/19 11:46
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        /*实例化本类对象*/
        Test test = new Test();
        /*实例化Data，并规范化*/
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd E HH-mm-ss");
        /*实例化学生，订单，订单项*/
        Student student = new Student("001","张三");
        Orders orders1 = new Orders("001",date);
        Orders orders2 = new Orders("002",date);
        OrderItems orderItems1 = new OrderItems("001",100);
        OrderItems orderItems2 = new OrderItems("002",200);
        OrderItems orderItems3 = new OrderItems("001",300);
        OrderItems orderItems4 = new OrderItems("002",120);
        OrderItems orderItems5 = new OrderItems("100",1000);
        /*实例化并初始化订单集合*/
        List <OrderItems> orderItemsList1 = new ArrayList<OrderItems>();
        orderItemsList1.add(orderItems1);
        orderItemsList1.add(orderItems2);
        List <OrderItems> orderItemsList2 = new ArrayList<>(Arrays.asList(orderItems3,orderItems4));
        /*定义orderOrderItemsMap存放订单与订单项的关系*/
        Map <Orders,List<OrderItems>> ordersOrderItemsMap = new HashMap<>();
        /*给ordersOrderItemsMap添加订单与订单项关系*/
        ordersOrderItemsMap.put(orders1,orderItemsList1);
        ordersOrderItemsMap.put(orders2,orderItemsList2);
        /*定义集合stuOrdersMap存放学生与订单关系*/
        Map <Student,Map<Orders, List<OrderItems>>> stuOrdersMap = new HashMap<>();
        /*添加学生与订单关系*/
        stuOrdersMap.put(student,ordersOrderItemsMap);
        /*遍历*/
        /*获取每个学生与订单订单项关系的键值*/
        Set <Student> ordersAllKey = stuOrdersMap.keySet();
        for (Student everyOrdersKey:ordersAllKey) {
            /*根据学生与订单订单项关系的键值获取每个订单与订单项集合关系*/
            Map<Orders, List<OrderItems>> everyOrders = stuOrdersMap.get(everyOrdersKey);
            /*获取每个订单与订单项关系集合的键值*/
            Set <Orders> everyOrderItemsKey = everyOrders.keySet();
            System.out.println(everyOrdersKey.stuNo+"号学生"+everyOrdersKey.stuName+"下单如下：");
            for (Orders everyOrderKey:everyOrderItemsKey) {
                System.out.println("订单"+everyOrderKey.getOrderId()+", 下单时间："+simpleDateFormat.format(everyOrderKey.getOrderTime()));
                /*根据订单与订单项关系集合的键值获取每一个订单项集合*/
                List<OrderItems> everyItems = everyOrders.get(everyOrderKey);
                /*遍历订单项集合*/
                for (OrderItems everyOrderItems:everyItems) {
                    System.out.println("    订单项编号："+everyOrderItems.getItemId()+", 订单项金额："+everyOrderItems.getMoney());
                }
            }
            test.deleteOrderItems("001",stuOrdersMap);
            test.addOrderItem(orderItems5,stuOrdersMap,"002");

        }
    }
    /*删除学号为001的学生订单项金额为200的所有订单项*/
    public void deleteOrderItems(String stuNo,Map<Student,Map<Orders, List<OrderItems>>> stuOrdersMap){
        /*声明一个订单与订单项集合关系的集合*/
        Map<Orders, List<OrderItems>> orderOrderItemsMap = null;
        /*获取stuOrdersMap的所有键值*/
        Set <Student> students = stuOrdersMap.keySet();
        /*遍历所有学生（键值）找到学号为001的学生*/
        for (Student everyStu: students) {
            /*根据学号判断*/
            if (everyStu.stuNo.equals(stuNo)){
                /*获取到这个学生对应的订单与订单项集合的关系*/
                orderOrderItemsMap = stuOrdersMap.get(everyStu);
                /*由于学号是唯一的，所以找到这个学生并获取关系集合后即可结束循环*/
                break;
            }
        }
        /*判断是否找到这个学生对应的关系集合*/
        if (orderOrderItemsMap != null){
            /*当前学生有订单*/
            /*获取该学生的订单与订单项关系集合的所有键值*/
            Set <Orders> Orders = orderOrderItemsMap.keySet();
            /*根据获取到的key遍历orderOrderItemsMap*/
            for (Orders everyOrders:Orders) {
                /*获取到每一个订单项集合*/
                List <OrderItems> everyOrderItemsList = orderOrderItemsMap.get(everyOrders);
                /*遍历每一个订单项*/
                /*获取everyOrderItemsList迭代器*/
                Iterator <OrderItems> itemsIterator = everyOrderItemsList.iterator();
                while (itemsIterator.hasNext()){
                    OrderItems everyorderItems = itemsIterator.next();
                    if (everyorderItems.getMoney() == 200){
                        itemsIterator.remove();
                    }
                }
            }
        }else {
            System.out.println("该学生没有对应的订单，不能删除");
        }

        /*判断是否找到这个学生对应的关系集合*/
        if(orderOrderItemsMap != null) {
            /*不为空，则获取学生与订单订单项关系集合的所有键值对*/
            Set <Map.Entry<Student,Map<Orders, List<OrderItems>>>> stuOrderKeyValue = stuOrdersMap.entrySet();
            /*遍历stuOrderKeyValue键值对集合*/
            for (Map.Entry<Student,Map<Orders, List<OrderItems>>> everystuOrderKeyValue:stuOrderKeyValue) {
                /*获取stuOrderKeyValue所有的键值对的键和值*/
                Student student = everystuOrderKeyValue.getKey();
                Map<Orders, List<OrderItems>> orderOrderItems = everystuOrderKeyValue.getValue();
                /*获取订单与订单项集合关系集合的所有键值对*/
                Set <Map.Entry<Orders, List<OrderItems>>>  orderOrderItemsKeyValue = orderOrderItems.entrySet();
                /*遍历orderOrderItemsKeyValue键值对集合*/
                for (Map.Entry<Orders, List<OrderItems>> everyOrderOrderItemsKeyValue:orderOrderItemsKeyValue) {
                    /*获取orderOrderItemsKeyValue所有的键和值*/
                    Orders everyOrder = everyOrderOrderItemsKeyValue.getKey();
                    List<OrderItems> everyOrderItemList = everyOrderOrderItemsKeyValue.getValue();
                    /*遍历每一个订单项*/
                    for (OrderItems everyOrderItem:everyOrderItemList) {
                        if (everyOrderItem.getMoney() == 200){
                            /*执行删除*/
                            everyOrderItemList.remove(everyOrderItem);
                        }else {
                            System.out.println(everyOrderItem);
                        }
                    }
                }
            }
        }
        else{
            System.out.println("改学生没有对应的订单，不能删除");
        }
    }
    
    /*将某个订单项加入到学生信息*/
    public  void addOrderItem(OrderItems orderItem,Map<Student,Map<Orders, List<OrderItems>>> stuOrdersMap,String stuNo){
        /*获取学生和订单与订单项关系集合的关系集合的所有键*/
        Set <Student> student = stuOrdersMap.keySet();
        /*先找到这个学生*/
        /*声明一个集合用来存放该学生订单与订单项集合的集合*/
        Map<Orders, List<OrderItems>> orderOrderItem = null;
        for (Student everystudent:student) {
            if (everystudent.stuNo.equals(stuNo)){
                /*获取这个学生的键值*/
                orderOrderItem = stuOrdersMap.get(everystudent);
                break;
            }else {
                Map<Orders,List<OrderItems>> orderOrderItem1  = new HashMap<>();
                String orderId = UUID.randomUUID().toString();
                String orderOrderItemId = UUID.randomUUID().toString();
                Orders orders = new Orders(orderId,new Date());
                OrderItems orderItems = new OrderItems(orderOrderItemId,500);
                List<OrderItems> list = new ArrayList<OrderItems>(Arrays.asList(orderItems));
                orderOrderItem1.put(orders,list);
                Student student1 = new Student(stuNo,"张三");
                Map <Student,Map<Orders, List<OrderItems>>> studentMapMap1 = new HashMap<>();
                studentMapMap1.put(student1,orderOrderItem1);
                System.out.println(studentMapMap1);
            }
        }
        if (orderOrderItem != null){
            /*在获取该学生的订单与订单项集合的集合的键值*/
            Set <Orders> order = orderOrderItem.keySet();
            /*遍历该集合获取每个订单项集合*/
            /*声明一个List<OrderItems>类型的集合用来存储该学生的订单项集合*/
            List<OrderItems> orderItemsList = null;
            for (Orders everyOrder:order) {
                orderItemsList = orderOrderItem.get(everyOrder);
            }
            /*遍历订单项集合*/
            if (orderItemsList != null){
                orderItemsList.add(orderItem);
            }
        }
        
    }
}
