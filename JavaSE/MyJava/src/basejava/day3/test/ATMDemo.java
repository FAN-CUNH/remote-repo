package basejava.day3.test;

import java.util.Scanner;

public class ATMDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
                //欢迎进去ATM 1登录   2 退出   登录用户信息账号：1234567
        while (true){
            System.out.println("欢迎进入ATM，请选择 1：登录  2：退出");
            String choose0 = scanner.next();
            if (choose0.equals("1")){
                // 登录界面
                System.out.println("请输入账号和密码：");
                String usernam = scanner.next();
                String password = scanner.next();
                if ((usernam.equals("1234567")) && (password.equals("123456"))){
                    System.out.println("密码正确");
                    //主界面
                    main1:while (true){
                        System.out.println("欢迎进入主界面:1 存款  2 取款  3 转账   4 退出");
                        String choose = scanner.next();
                        if(choose.equals("1")){
                            //存款界面
                            cunKuan:while (true){
                                System.out.println("欢迎进入存款界面：1 输入存款金额   2 退回主界面");
                                String choose1 = scanner.next();
                                if(choose1.equals("1")){
                                    System.out.println("请输入金额");
                                    double money = scanner.nextDouble();
                                    System.out.println("存款金额位："+money);
                                }
                                else if(choose1.equals("2")){
                                    continue  main1;//接着主界面
                                }
                                else{
                                    System.out.println("存款界面没有该服务");
                                }
                            }
                        }
                        else if(choose.equals("2")){
                            //取款
                            quKuan:while (true){
                                System.out.println("欢迎进入取款界面：1 输入取款金额   2 退回主界面");
                                String choose1 = scanner.next();
                                if(choose1.equals("1")){
                                    System.out.println("请输入金额");
                                    double money = scanner.nextDouble();
                                    System.out.println("取款金额为："+money);
                                }
                                else if(choose1.equals("2")){
                                    continue  main1;//接着主界面
                                }
                                else{
                                    System.out.println("取款界面没有该服务");
                                }
                            }

                        }else if(choose.equals("3")){
                            //转账
                            zhuanZhang:while (true){
                                System.out.println("欢迎进入转账界面：1 输入转账金额   2 退回主界面");
                                String choose1 = scanner.next();
                                if(choose1.equals("1")){
                                    System.out.println("请输入金额");
                                    double money = scanner.nextDouble();
                                    System.out.println("转账金额为："+money);
                                }
                                else if(choose1.equals("2")){
                                    continue  main1;//接着主界面
                                }
                                else{
                                    System.out.println("存款界面没有该服务");
                                }
                            }

                        }else if(choose.equals("4")){
                            break; // 退出
                        }
                        else{
                            System.out.println("没有该服务");
                        }
                    }
                }
                else {
                    System.out.println("密码错误");
                    count++;
                    if (count >= 3) // 3次输入错误 退出
                        break;
                }
            }
            else if (choose0.equals("2")){
                break;
            }
            else {
                System.out.println("ATM机没有该选项");
                break;
            }
        }

    }
}
