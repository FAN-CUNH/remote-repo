package javase.day2.work.bank;

public class Account {
    //私有属性
    private String accName;
    private String accId;
    private String accSex;
    private int accAge;
    private double accBalance;//余额

    // getset方法
    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getAccSex() {
        return accSex;
    }

    public void setAccSex(String accSex) {
        this.accSex = accSex;
    }

    public int getAccAge() {
        return accAge;
    }

    public void setAccAge(int accAge) {
        this.accAge = accAge;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    // 构造方法
    public Account() {
    }

    public Account(String accName, String accId, String accSex, int accAge, double accBalance) {
        this.accName = accName;
        this.accId = accId;
        this.accSex = accSex;
        this.accAge = accAge;
        this.accBalance = accBalance;
    }

    @Override
    public String toString() {
        return "当前账户信息[" +
                "账户名" + accName +
                ", 卡号" + accId +
                ", 性别" + accSex +
                ", 年龄" + accAge +
                ", 余额" + accBalance +
                ']';
    }

    //自定义行为  取款
    public Account  withdraw(double accBalance){
        //判断余额是否够，够取款；不够打印余额不足
        if (this.accBalance >= accBalance){
            this.setAccBalance(this.accBalance-accBalance);
            System.out.println(accBalance+"元取款成功,"+this);
        }else {
            System.out.println("余额不足！！！"+this);
        }
        return this;
    }
    //自定义行为  存款
    public Account deposit(double accBalance) {
        this.setAccBalance(accBalance+this.getAccBalance());
        System.out.println("元存款成功,"+this.getAccBalance());
        return this;
    }
}
