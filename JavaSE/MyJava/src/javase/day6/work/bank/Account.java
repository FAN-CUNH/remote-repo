package javase.day6.work.bank;

public class Account {
    /*普通账户类：五个私有成员变量，分别是余额balance，卡号accountId,姓名name,身份证号personId,密码password*/
    private double balance;
    private int accountId;
    private String name;
    private int personId;
    private String password;

    /*setger方法*/

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*构造方法*/

    public Account() {
    }
    /*卡号是自动生成的我们不能对其更改和赋值*/
    public Account(double balance, String name, int personId, String password) {
        this.balance = balance;
        this.name = name;
        this.personId = personId;
        this.password = password;
    }

    /*重写toString方法，使其显示账户基本信息*/

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", accountId=" + accountId +
                ", name='" + name + '\'' +
                ", personId=" + personId +
                ", password='" + password + '\'' +
                '}';
    }
}
