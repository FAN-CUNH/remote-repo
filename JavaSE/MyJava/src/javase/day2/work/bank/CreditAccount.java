package javase.day2.work.bank;

public class CreditAccount extends Account{
    private  double ceilgMoney;//信用额度

    // setget行为
    public double getCeilgMoney() {
        return ceilgMoney;
    }

    public void setCeilgMoney(double ceilgMoney) {
        this.ceilgMoney = ceilgMoney;
    }

    // 构造行为
    public CreditAccount() {
    }

    public CreditAccount(String accName, String accId, String accSex, int accAge, double accBalance, double ceilgMoney) {
        super(accName, accId, accSex, accAge, accBalance);
        this.ceilgMoney = ceilgMoney;
    }

    @Override
    public String toString() {
        return "当前账户信息[" +
                "账户名" + this.getAccName() +
                ", 卡号" + this.getAccId() +
                ", 性别" + this.getAccSex() +
                ", 年龄" + this.getAccAge() +
                ", 余额" + this.getAccBalance() +
                ", 信用额度" + this.getCeilgMoney() +
                ']';
    }

    @Override
    public Account withdraw(double money) {
         //信用额度可以参与取款的：money只要在accBalance+ceilgMoney范围内都是允许取款
        if (this.getAccBalance()+this.ceilgMoney < money){ // 取款金额大于信用额度加上余额
            System.out.println("余额不足！！！");

        }else if (this.getAccBalance() >= money){ // 当前余额够用，不动信用额度
            this.setAccBalance(getAccBalance() - money);
            System.out.println(money+"取款成功,"+this);
        }else{
            this.setCeilgMoney(getCeilgMoney() - (money-getAccBalance())); // 取款金额大于余额小于余额+信用额度
            this.setAccBalance(0);
            System.out.println(money+"取款成功"+this);
        }

        /*Account account = new CreditAccount();*/
        return this;//this是信用卡对象
    }
}
