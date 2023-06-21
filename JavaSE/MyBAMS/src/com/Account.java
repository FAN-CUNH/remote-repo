package com;

/**
 * @ClassName Account
 * @Description 账户抽象模版类 -> 业务数据
 * @Author Cunhao Fan
 * @Date 2023/5/5 9:37
 * @Version 1.0
 */
public abstract class Account {
    /*成员变量*/

    /*账户号码*/
    private long id;
    /*账户密码*/
    private String password;
    /*真实姓名*/
    private String name;
    /*身份证号码*/
    private String personId;
    /*客户电子邮箱*/
    private String email;
    /*账户余额*/
    private double balance;

    /*构造方法*/

    public Account(long id, String password, String name, String personId, String email, double balance) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.personId = personId;
        this.email = email;
        this.balance = balance;
    }

    public Account() {
    }


    /*setter getter方法*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /*成员方法*/

    /**
     * @Description 存款
     * @param money
     * @return Account
     * @Author Cunhao Fan
     * @Date 2023/5/5 9:44
     */
    public final Account deposit(double money) {
        Account account = null;
        return account;
    }

    /**
     * @param money
     * @return Account
     * @Description 抽象取款方法 -> 子类重写此方法
     * @Author Cunhao Fan
     * @Date 2023/5/5 9:45
     */
    public abstract Account withdraw(double money);

    /*重写toString方法*/

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password +
                ", name=" + name +
                ", personId=" + personId +
                ", email=" + email +
                ", balance=" + balance +
                '}';
    }
}
