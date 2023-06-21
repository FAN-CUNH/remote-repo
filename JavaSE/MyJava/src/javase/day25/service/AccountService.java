package javase.day25.service;

import javase.day25.dao.AccountDao;
import javase.day25.entity.Account;
import javase.day25.entity.CreditAccount;
import javase.day25.entity.Page;
import javase.day25.entity.SavingAccount;

import java.util.List;

/**
 * @packageName javase.day25.service
 * @ClassName AccountService
 * @Description 业务逻辑层
 * @Author CunHao Fan
 * @Date 2023/5/24 18:08
 * @Version 1.0
 */
public class AccountService {

    /**
     * 声明AccountDao，调用数据访问层
     */
    AccountDao accountDao = null;

    /**
     * 无参构造 并且实例化本类的同时实例化AccountDao
     */
    public AccountService() {
        accountDao = new AccountDao();
    }

    /**
     * 登录
     * @param id 账号
     * @param password 密码
     * @param type 类型
     * @return 返回账户对象
     */
    public Account login(String id, String password, String type) {
        return accountDao.login(id, password, type);
    }

    /**
     * 储蓄账户注册
     * @param id 账号
     * @param password 密码
     * @param name 姓名
     * @param personId 身份证号
     * @param email 邮箱
     * @param balance 余额
     * @return 返回一个储蓄账户对象
     */
    public void savingAccountRegister(int id, String password, String name, String personId, String email, double balance) {
        accountDao.savingAccountRegister(id,password, name, personId, email, balance);
    }

    /**
     * 信用账户注册
     * @param id 账号
     * @param password 密码
     * @param name 姓名
     * @param personId 身份证号
     * @param email 邮箱
     * @param balance 余额
     * @param ceiling 信用额度
     * @return 返回一个信用账户
     */
    public void creditAccountRegister(int id, String password, String name, String personId, String email, double balance, double ceiling) {
        accountDao.creditAccountRegister(id,password, name, personId, email, balance, ceiling);
    }

    /**
     * @param currentPage 当前页码
     * @param pageShowCount 每页展示条数
     * @return page对象
     */
    public Page<Account> getPage(int currentPage, int pageShowCount) {
        return accountDao.getPage(currentPage, pageShowCount);
    }


    public boolean transfer(String fromId, String fromType, String targetId, String targetType, double money) {
        return accountDao.transfer(fromId, fromType, targetId, targetType, money);
    }

    public boolean withdraw(String accountId,String accountType, double money) {
        return accountDao.withdraw(accountId, accountType, money);
    }

    public void deposit(String accountId,String accountType, double money) {
        accountDao.deposit(accountId, accountType, money);
    }

    public Account getMess(String accountId, String accountType) {
        return accountDao.getMess(accountId, accountType);
    }

    public List<Account> rank() {
        return accountDao.rank();
    }
}
