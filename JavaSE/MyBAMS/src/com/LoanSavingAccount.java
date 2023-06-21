package com;

/**
 * @ClassName LoanSavingAccount
 * @Description 可以贷款不可以透支账户
 * @Author Cunhao Fan
 * @Date 2023/5/5 19:33
 * @Version 1.0
 */
public class LoanSavingAccount extends SavingAccount implements Loanable{
    /*成员变量*/


    /*贷款金额*/
    private double loanAmount;
    /*构造方法*/

    public LoanSavingAccount(long id, String password, String name, String personId, String email, double balance, long loanAmount) {
        super(id, password, name, personId, email, balance);
        this.loanAmount = loanAmount;
    }

    public LoanSavingAccount(long loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * @Description 用户贷款的实现方法
     * @param money 贷款金额
     * @return Account
     * @Author Cunhao Fan
     * @Date 2023/5/5 19:42
     */
    @Override
    public Account requestLoan(double money) {
        this.loanAmount = money;
        System.out.println(money+"贷款成功！");
        return this;
    }


    /**
     * @Description 用户还款的实现方法
     * @param money 还款金额
     * @return Account
     * @Author Cunhao Fan
     * @Date 2023/5/5 19:42
     */
    @Override
    public Account payLoan(double money) {
        if (this.getBalance() > loanAmount) {
            this.setBalance(getBalance() - loanAmount);
            loanAmount = 0;
            System.out.println("还贷成功，贷款已还清！");
        } else {
            this.loanAmount = this.loanAmount - this.getBalance();
            this.setBalance(0);
            System.out.println("还贷成功，剩余贷款"+this.loanAmount);
        }
        return this;
    }

    /*重写toString*/

    @Override
    public String toString() {
        return "LoanSavingAccount{" +
                "id=" + super.getId() +
                ", password='" + super.getPassword() +
                ", name=" + super.getName() +
                ", personId=" + super.getPersonId() +
                ", email=" + super.getEmail() +
                ", balance=" + super.getBalance() +
                ", loanAmount=" + loanAmount +
                '}';
    }
}
