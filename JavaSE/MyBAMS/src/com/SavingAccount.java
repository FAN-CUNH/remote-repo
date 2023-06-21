package com;

/**
 * @ClassName SavingAccount
 * @Description 储蓄账户 -> 储蓄账户不允许透支
 * @Author Cunhao Fan
 * @Date 2023/5/5 9:49
 * @Version 1.0
 */
public class SavingAccount extends Account{

    /*构造方法*/
    public SavingAccount(long id, String password, String name, String personId, String email, double balance) {
        super(id, password, name, personId, email, balance);
    }

    public SavingAccount() {
    }

    public SavingAccount(long id, String password, String name, String personId, String email) {
    }


    @Override
    public Account withdraw(double money) {
        return null;
    } // 继承账户类

    /*重写toString方法*/

}
