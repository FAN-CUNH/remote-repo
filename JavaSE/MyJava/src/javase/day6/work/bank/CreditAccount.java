package javase.day6.work.bank;

public class CreditAccount extends Account{
    /*信用账户：继承普通账户,有特有的属性信用额度credits*/
    private double credits;

    /*setget方法*/
    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    /*构造方法*/
    public CreditAccount(double credits) {

    }

    public CreditAccount(double balance, String name, int personId, String password, double credits) {
        super(balance, name, personId, password);
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "balance=" + this.getBalance() +
                ", accountId=" + this.getAccountId() +
                ", name=" + this.getName() +
                ", credits=" + credits +
                '}';
    }
}
