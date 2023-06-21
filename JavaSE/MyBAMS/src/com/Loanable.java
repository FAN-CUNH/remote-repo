package com;

/**
 * @ClassName Loanable
 * @Description 贷款接口
 * @Author Cunhao Fan
 * @Date 2023/5/5 19:28
 * @Version 1.0
 */
public interface Loanable {
    /*成员方法*/

    /**
     * @Description 贷款抽象方法
     * @param money 贷款金额
     * @return Account
     * @Author Cunhao Fan
     * @Date 2023/5/5 19:30
     */
    public Account requestLoan(double money);

    /**
     * @Description 还贷抽象方法
     * @param money 还款金额
     * @return Account
     * @Author Cunhao Fan
     * @Date 2023/5/5 19:32
     */
    public Account payLoan(double money);
}
