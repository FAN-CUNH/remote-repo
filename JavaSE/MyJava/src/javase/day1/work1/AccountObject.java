package javase.day1.work1;

public class AccountObject {
    public static void main(String[] args) {
        // 创建实例化账户对象
        Account myAccount = new Account();
        Student student = new Student();
        // 初始化属性信息
        myAccount.setAccountName("张三");
        myAccount.setAccountId("zs123456");
        // 调用对象的方法
        myAccount.stuMess();
        student.setStuName("麻子01");
        myAccount.changeStuMess(student);
        System.out.println(student.getStuName());
        System.out.println(myAccount.backMess().getAccountName()+myAccount.backMess().getAccountId());

    }
}
