package javase.day2.work.bank;

public class SavingAccount extends Account {
    // 构造行为
    public SavingAccount() {
        // 省略了super()
    }

    public SavingAccount(String accName, String accId, String accSex, int accAge, double accBalance) {
        super(accName, accId, accSex, accAge, accBalance); // 调用父类的有参构造
    }
    // 重写存款行为
    @Override
    public Account deposit(double accBalance) {
            this.setAccBalance(accBalance+this.getAccBalance());
            System.out.println(accBalance+"存款成功,"+this);
            return this;
    }
}
