package javase.day25.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javase.day25.entity.Account;
import javase.day25.entity.CreditAccount;
import javase.day25.entity.Page;
import javase.day25.entity.SavingAccount;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @packageName javase.day25.dao
 * @ClassName AccountDao
 * @Description 数据访问层
 * @Author CunHao Fan
 * @Date 2023/5/24 18:08
 * @Version 1.0
 */
public class AccountDao {
    /**
     * QueryRunner
     */
    QueryRunner queryRunner;
    Connection connection;
    final String SAVING = "储蓄账户";
    final String CREDIT = "信用账户";


    /**
     * 无参构造 且实例化成员变量
     */
    public AccountDao() {
        DataSource dataSource = new ComboPooledDataSource("mysql");
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        queryRunner = new QueryRunner();
        System.out.println(connection);
        Locale locale = new Locale("zh", "CN");
    }


    /**
     * 通过账号和密码登录，并且选择登录账号类型
     *
     * @param id       账号
     * @param password 账户密码
     * @param type     账户类型
     * @return 返回该账户对象信息
     */
    public Account login(String id, String password, String type) {
        /*声明一个账户类型用于存储登录账户*/
        Account account = null;
        /*定义账户类型*/
        if (SAVING.equals(type)) {
            /*登录账户为存储账户*/
            /*sql语句*/
            String sql = String.format("select * from savingAccount where id = '%s' and password = '%s' ", id, password);
            try {
                /*执行sql 并且处理结果集*/
                account = queryRunner.query(connection, sql, new BeanHandler<>(SavingAccount.class));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else if (CREDIT.equals(type)) {
            /*信用账户*/
            /*sql语句*/
            String sql = String.format("select * from creditAccount where id = '%s' and password = '%s'", id, password);
            try {
                /*执行sql 并且处理结果集*/
                account = queryRunner.query(connection, sql, new BeanHandler<>(CreditAccount.class));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return account;
    }

    /**
     * 储蓄账户注册
     *
     * @param id       账号
     * @param password 密码
     * @param name     姓名
     * @param personId 身份证号
     * @param email    邮箱
     * @param balance  余额
     * @return 返回一个储蓄账户对象
     */
    public void savingAccountRegister(int id, String password, String name, String personId, String email,
                                      double balance) {
        String sql = String.format("insert into savingAccount values ('%S', '%S', '%S', '%S', '%S', '%S')", id, password, name, personId, email, balance);
        try {
            queryRunner.update(connection, sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 信用账户注册
     *
     * @param id       账号
     * @param password 密码
     * @param name     姓名
     * @param personId 身份证号
     * @param email    邮箱
     * @param balance  余额
     * @param ceiling  信用额度
     * @return 返回一个信用账户
     */
    public void creditAccountRegister(int id, String password, String name, String personId, String email,
                                      double balance, double ceiling) {
        String sql = String.format("insert into creditAccount values ('%S', '%S', '%S', '%S', '%S', '%S', '%S')", id, password, name, personId, email, balance, ceiling);
        try {
            /*执行sql*/
            queryRunner.update(connection, sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 通过当前页码和每页展示条数计算出总页数和查询每页数据 然后实例化page
     *
     * @param currentPage   当前页码
     * @param pageShowCount 每页展示条数
     * @return 返回一个page对象
     */
    public Page<Account> getPage(int currentPage, int pageShowCount) {
        /*实例化页面*/
        Page<Account> accountPage = new Page<>();
        /*给页面的四个成员变量赋值*/

        /*设置当前页码*/
        accountPage.setCurrentPage(currentPage);
        /*设置每页显示记录数目*/
        accountPage.setEveryPageSize(3);
        /*设置总页数 总页数由总记录数除以每页显示数目并向上取整*/
        long count1 = 0;
        long count2 = 0;
        long count;
        try {
            count1 = (long) queryRunner.query(connection, "select count(*) from savingAccount", new ScalarHandler());
            count2 = (long) queryRunner.query(connection, "select count(*) from creditAccount", new ScalarHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        count = count1 + count2;
        System.out.println("总记录数" + count);
        System.out.println((int) Math.ceil(count / pageShowCount));
        accountPage.setAllPageCount((int) Math.ceil(count % pageShowCount));
        /*设置每页显示的内容*/
        /*实例化一个集合用来存储查询到的记录*/
        List<Account> accounts = new ArrayList<>();
        String sql = String.format("select id, password, balance from savingAccount union select id, password, balance from creditAccount limit %s, %s", currentPage - 1, pageShowCount);
        System.out.println(sql);
        try {
            accounts = queryRunner.query(connection, sql, new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        accountPage.setMapList(accounts);
        return accountPage;
    }


    /**
     * 转账
     *
     * @param fromId     转出账户
     * @param fromType   账户类型
     * @param targetId   转入账户
     * @param targetType 账户类型
     * @param money      金额
     */
    int sqlResult1, sqlResult2;

    public boolean transfer(String fromId, String fromType, String targetId, String targetType, double money) {
        boolean isTransfer = false;
        /*sql语句*/
        String sql1 = String.format("update savingAccount  set balance = balance - %s where id = %s", money, fromId);
        String sql2 = String.format("update savingAccount set balance = balance + %s where id = %s", money, targetId);
        String sql3 = String.format("update creditAccount  set balance = balance - %s where id = %s", money, fromId);
        String sql4 = String.format("update creditAccount set balance = balance + %s where id = %s", money, targetId);
        try {
            /*设置开启事务*/
            connection.setAutoCommit(false);
            /*执行sql*/
            /*四种情况
             * 1 储蓄转储蓄
             * 2 储蓄转信用
             * 3 信用转信用
             * 4 信用转储蓄
             */
            if (fromType.equals(targetType)) {
                /*储蓄转储蓄*/
                if (SAVING.equals(fromType)) {
                    sqlResult1 = queryRunner.update(connection, sql1);
                    sqlResult2 = queryRunner.update(connection, sql2);
                    System.out.println(sql1);
                    System.out.println(sql2);
                }
                /*信用转信用*/
                else {
                    sqlResult1 = queryRunner.update(connection, sql3);
                    sqlResult2 = queryRunner.update(connection, sql4);
                    System.out.println(sql3);
                    System.out.println(sql4);
                }
            } else {
                /*储蓄转信用*/
                if (SAVING.equals(fromType)) {
                    sqlResult1 = queryRunner.update(connection, sql1);
                    sqlResult2 = queryRunner.update(connection, sql4);
                    System.out.println(sql1);
                    System.out.println(sql4);
                }
                /*信用转储蓄*/
                else {
                    sqlResult1 = queryRunner.update(connection, sql3);
                    sqlResult2 = queryRunner.update(connection, sql2);
                    System.out.println(sql3);
                    System.out.println(sql2);
                }
            }
            /*提交事务*/
            if (sqlResult1 > 0 && sqlResult2 > 0) {
                /*当sql语句对表造成影响提交事务*/
                connection.commit();
                isTransfer = true;
            }
            else {
                /*回滚事务*/
                connection.rollback();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            /*遇到异常回滚事务*/
            try {
                connection.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isTransfer;
    }

    /**
     * 取款
     *
     * @param accountId 取款账户
     * @param money     取款金额
     */
    double balance;

    public boolean withdraw(String accountId, String accountType, double money) {
        boolean isWithdraw = false;
        /*sql语句*/
        String save = String.format("update savingAccount set balance = balance - %s where id = %s", money, accountId);
        String credit = String.format("update creditAccount set balance = balance - %s where id = %s", money, accountId);
        if (SAVING.equals(accountType)) {
            try {
                /*判断余额否大于取款金额*/
                balance = Double.parseDouble(queryRunner.query(connection, "select balance from savingAccount where id = " + accountId, new ScalarHandler()).toString());
                if (balance > money) {
                    queryRunner.update(connection, save);
                    isWithdraw = true;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            try {
                /*判断余额否大于取款金额*/
                balance = (double) queryRunner.query(connection, "select balance from creditAccount where id = " + accountId, new ScalarHandler());
                if (balance > money) {
                    queryRunner.update(connection, credit);
                    isWithdraw = true;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return isWithdraw;
    }

    /**
     * 存款
     *
     * @param accountId   存款账户
     * @param accountType 账户类型
     * @param money       存款金额
     */
    public void deposit(String accountId, String accountType, double money) {
        /*sql语句*/
        String save = String.format("update savingAccount set balance = balance + %s where id = %s", money, accountId);
        String credit = String.format("update creditAccount set balance = balance + %s where id = %s", money, accountId);
        if (SAVING.equals(accountType)) {
            try {
                queryRunner.update(connection, save);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            try {
                queryRunner.update(connection, credit);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 获取登录人信息
     *
     * @param accountId   账户id
     * @param accountType 账户类型
     * @return 返回一个账户对象
     */
    public Account getMess(String accountId, String accountType) {
        /*实例化一个账户用于接收登录人的信息*/
        Account account = null;
        /*sql语句*/
        String save = String.format("select * from savingAccount where id = %s", accountId);
        String credit = String.format("select * from creditAccount where id = %s", accountId);
        /*根据accountType判断账户类型*/
        /*储蓄账户*/
        if (SAVING.equals(accountType)) {
            /*执行sql语句处理结果集*/
            try {
                account = queryRunner.query(connection, save, new BeanHandler<>(SavingAccount.class));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        /*信用账户*/
        else {
            /*执行sql语句处理结果集*/
            try {
                account = queryRunner.query(connection, credit, new BeanHandler<>(CreditAccount.class));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return account;
    }

    /**
     * 获取银行中用户资产排名
     * @return 返回一个结合
     */
    public List<Account> rank() {
        /*创建一个集合用于存储查询到的账户排名信息*/
        ArrayList<Account> accountArrayList = null;
        /*sql语句*/
        String sql = String.format("select id, name, balance from savingAccount union select id, password, balance from creditAccount order by BALANCE desc");
        try {
            accountArrayList = (ArrayList<Account>) queryRunner.query(connection, sql, new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accountArrayList;
    }
}
