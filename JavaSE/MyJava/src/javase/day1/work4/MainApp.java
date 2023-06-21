package javase.day1.work4;

public class MainApp {
    public static void main(String[] args) {
        // 创建项目经理的实例化对象
        Manager manager = new Manager("张三","123",15000.00,6000);
        Coder coder = new Coder("李四","135",15000.00);
        // 调用成员方法
        manager.work();
        coder.work();

    }
}
