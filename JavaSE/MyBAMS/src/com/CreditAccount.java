package com;

/**
 * @ClassName CreditAccount
 * @Description 信用账户 -> 信用账户可以透支,并在用户在满足银行条件的情况下允许用户调整自己的透支额度.
 * @Author Cunhao Fan
 * @Date 2023/5/5 10:00
 * @Version 1.0
 */
public class CreditAccount extends Account{
    /*成员变量*/

    /*透支额度*/
    private double ceiling;

    /*构造方法*/

    public CreditAccount(long id, String password, String name, String personId, String email, double balance, double ceiling) {
        super(id, password, name, personId, email, balance);
        this.ceiling = ceiling;
    }

    public CreditAccount(double ceiling) {
        this.ceiling = ceiling;
    }

    /*setter getter方法*/

    public double getCeiling() {
        return ceiling;
    }

    public void setCeiling(double ceiling) {
        this.ceiling = ceiling;
    }

    /*重写Account中的抽象方法*/
    @Override
    public Account withdraw(double money) {
        return null;
    }

    /*重写toString方法*/

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id=" + super.getId() +
                ", password='" + super.getPassword() +
                ", name=" + super.getName() +
                ", personId=" + super.getPersonId() +
                ", email=" + super.getEmail() +
                ", balance=" + super.getBalance() +
                ", ceiling=" + ceiling +
                '}';

    }
}
