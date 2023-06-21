package com;

/**
 * @ClassName LoanCreditAccount
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/5 19:34
 * @Version 1.0
 */
public class LoanCreditAccount extends CreditAccount implements Loanable{
    /*成员变量*/


    /*贷款金额*/
    private double loanAmount;

    /*构造方法*/

    public LoanCreditAccount(long id, String password, String name, String personId, String email, double balance, double ceiling, long loanAmount) {
        super(id, password, name, personId, email, balance, ceiling);
        this.loanAmount = loanAmount;
    }

    public LoanCreditAccount(double ceiling, long loanAmount) {
        super(ceiling);
        this.loanAmount = loanAmount;
    }


    @Override
    public Account requestLoan(double money) {
        System.out.println(money+"贷款成功！");
        this.loanAmount = money;
        return this;
    }

    @Override
    public Account payLoan(double money) {
        if (this.getBalance() > loanAmount) {
            this.setBalance(getBalance() - loanAmount);
            loanAmount = 0;
            System.out.println("还贷成功，贷款已还清！");
        } else if (this.getBalance() + this.getCeiling() > this.loanAmount){
            this.setCeiling(this.getBalance() + this.getCeiling() - this.loanAmount);
            this.setBalance(0);
            this.loanAmount = 0;
            System.out.println("还贷成功，余额不足，利用信用卡额度已还清贷款");
        } else {
             this.loanAmount = this.loanAmount - (this.getBalance() + this.getCeiling());
             this.setBalance(0);
             this.setCeiling(0);
            System.out.println("还贷成功，余额和信用额度不足以还清，贷款剩余"+this.loanAmount);
        }
        return this;
    }

    /*toString方法*/

    @Override
    public String toString() {
        return "LoanCreditAccount{" +
                "id=" + super.getId() +
                ", password='" + super.getPassword() +
                ", name=" + super.getName() +
                ", personId=" + super.getPersonId() +
                ", email=" + super.getEmail() +
                ", balance=" + super.getBalance() +
                ", ceiling=" + super.getCeiling() +
                ", loanAmount=" + loanAmount +
                '}';
    }
}
