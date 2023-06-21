package com;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/5 13:04
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        //ArrayList<Account> accounts = new ArrayList<Account>();
        Account[] accounts = new Account[100];
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank(accounts);
        while (true) {
            System.out.println("---------------------欢迎进入银行ATM界面---------------------");
            System.out.println("0：注册账户  1：登录账户");
            System.out.println("请选择服务项目：");
            String command = scanner.next();
            switch (command) {
                case "0": {
                    boolean register = true;
                    while (register) {
                        System.out.println("---------------------欢迎进入开户界面---------------------");
                        System.out.println("请设置账户密码：");
                        String password = scanner.next();
                        System.out.println("请确认账户密码：");
                        String checkPassword = scanner.next();
                        if (!password.equals(checkPassword)){
                            register = false;
                            System.out.println("两次密码不一致!请重新输入：");
                        }else {
                            System.out.println("请输入姓名：");
                            String name = scanner.next();
                            System.out.println("请输入身份证号码：");
                            String personId = scanner.next();
                            System.out.println("请输入邮箱");
                            String email = scanner.next();
                            System.out.println("请选择账户类型 0：储蓄账户 1：信用账户 2：可贷款储蓄账户 3：可贷款信用账户");
                            int accountType = scanner.nextInt();
                            bank.register(password, checkPassword, name, personId, email, accountType);
                            break;
                        }
                    }
                    break;
                }
                case "1": {
                    System.out.println("---------------------欢迎进入登录界面---------------------");
                    System.out.println("请输入账户id：");
                    long id = scanner.nextLong();
                    System.out.println("请输入账户密码：");
                    String password = scanner.next();
                    bank.login(id, password);
                    break;
                }
            }
        }
    }
}
