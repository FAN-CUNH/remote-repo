package javase.day2.work.bank;

public class AccountMainApp {
    public static void main(String[] args) {
        //实例化一个存储账户对象
        Account zhangSan = new SavingAccount("张三","savingAcc001","男",23,18800.0);


        //实例化一个信用账户对象
        Account liSi = new CreditAccount("李四","creditAcc001","男",23,13800.0,5000.0);

        //调用取款方法
        zhangSan.withdraw(200);
        zhangSan.withdraw(20000);
        zhangSan.deposit(1200);
        System.out.println("----------我----------是----------分----------隔----------符----------");
        //调用存款方法
        liSi.withdraw(15000);
    }
}
