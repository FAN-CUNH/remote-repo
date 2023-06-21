package javase.day6.work.bank;

import java.util.Scanner;

public class BankTest {
    public static void main(String[] args) {
        /*实例化取款机对象*/
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        /*1:开户 2: 登录 0:退出系统*/
        while (true){
            /*接收键盘键入信息*/
            System.out.println("请选择：1:开户 2: 登录 0:退出系统");
            String chosse1 = scanner.next();
            if (chosse1.equals("1")){
                /*开户*/
                System.out.println("请输入开户人信息：类型,姓名,身份证号,密码");
                String type = scanner.next();
                String name = scanner.next();
                int personId = scanner.nextInt();
                String password = scanner.next();
                Account account = bank.regedit(type,name,personId,password);
                System.out.println(account);
            }else if(chosse1.equals("2")){
                /*登录*/
                System.out.println("请输入登录账户和密码：");
                int accountId = scanner.nextInt();
                String password = scanner.next();
                bank.load(accountId,password);
                /*登录成功，选择1：存款 2：取款 3：转账 4：设置信用额度 5：返回上一级*/
                System.out.println("请选择以下操作：1:存款 2:取款 3:转账 4:设置信用额度 5:返回上一级");
                String choose2 = scanner.next();
                switch (choose2){
                    case "1":{
                        /*调用deposit*/
                        System.out.println("请输入存款金额:");
                        double money = scanner.nextDouble();
                        bank.deposit(accountId,money);
                        break;
                    }
                    case "2":{
                        /*调用withdraw*/
                        System.out.println("请输入取款金额:");
                        double money = scanner.nextDouble();
                        bank.withdraw(accountId,money);
                        break;
                    }
                    case "3":{
                        System.out.println("请输入转账账户和金额:");
                        int targetAccountId = scanner.nextInt();
                        double money = scanner.nextDouble();
                        bank.transfer(accountId,targetAccountId,money);
                        break;
                    }
                    case "4":{
                        System.out.println("请输入信用额度:");
                        double money = scanner.nextDouble();
                        bank.setCredit(accountId,money);
                        break;
                    }
                    case "5":{
                        /*返回上一级*/
                        break;
                    }
                    default:{
                        System.out.println("没有此服务");
                        break;
                    }
                }
            }else{
                /*退出*/
                break;
            }
        }

    }
}
