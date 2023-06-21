package javase.day6.work.bank;

public class SavingAccount extends Account{
    /*储蓄账户：继承普通账户*/
    /*构造方法*/
    public SavingAccount() {
    }

    public SavingAccount(double balance, String name, int personId, String password) {
        super(balance, name, personId, password);
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "balance=" + getBalance() +
                ", accountId=" + getAccountId() +
                ", name='" + getName() +
                "}";
    }
}
