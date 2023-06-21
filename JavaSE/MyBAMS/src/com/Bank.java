package com;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

/**
 * @ClassName Bank
 * @Description 银行 -> 1.当前所有的账户对象的信息,存放在数组中: Account[]. 2.当前账户数量index.
 * @Author Cunhao Fan
 * @Date 2023/5/5 10:03
 * @Version 1.0
 */
public class Bank {
    /*成员变量*/

    /*账户类型数组用于存放所有账户*/
    private Account[] allAccounts;
    /*账户数量*/
    private static int index = 0;

    /*构造方法*/

    public Bank(Account[] allAccounts) {
        this.allAccounts = allAccounts;
    }

    public Account[] getAllAccounts() {
        return allAccounts;
    }

    public void setAllAccounts(Account[] allAccounts) {
        this.allAccounts = new Account[100];
    }

    Scanner scanner = new Scanner(System.in);
    /*成员方法*/

    /**
     * @Description 用户开户
     * @param password 账户密码
     * @param checkPassword 确认账户密码
     * @param name 开户人姓名
     * @param personId 开户人身份证号
     * @param email 开户人电子邮箱
     * @param accountType 开户账户类型 -> 项目需求规定账户类型：0 – 储蓄账户  1 – 信用账户 2 – 可贷款储蓄账户 3– 可贷款信用账户
     * @return Account 返回此账户
     * @Author Cunhao Fan
     * @Date 2023/5/5 10:25
     */
    public Account register(String password, String checkPassword, String name, String personId, String email, int accountType) {
        Account account = null;
        switch (accountType) {
            case 0: { // 储蓄账户
                long id = Long.parseLong(accountId());
                account = new SavingAccount(id, password, name, personId, email, 0);
                System.out.println("开户中...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("*"+name.substring(1)+"的储蓄账户开户成功！账户id为"+id);
                allAccounts[index] = account;
                index += 1;
                break;
            }
            case 1: { // 信用账户
                long id = Long.parseLong(accountId());
                account = new CreditAccount(id, password, name, personId, email, 0, 1000);
                System.out.println("开户中...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("*"+name.substring(1)+"的信用账户开户成功！！账户id为"+id);
                allAccounts[index] = account;
                index += 1;
                break;
            }
            case 2: { // 可贷款储蓄账户
                long id = Long.parseLong(accountId());
                account = new LoanSavingAccount(id, password, name, personId, email, 0, 0);
                System.out.println("开户中...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("*"+name.substring(1)+"的可贷款储蓄账户开户成功！！账户id为"+id);
                allAccounts[index] = account;
                index += 1;
                break;
            }
            case 3: { // 可贷款信用账户
                long id = Long.parseLong(accountId());
                account = new LoanCreditAccount(id, password, name, personId, email, 0, 1000, 0);
                System.out.println("开户中...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("*"+name.substring(1)+"的可贷款信用账户开户成功！！账户id为"+id);
                allAccounts[index] = account;
                index += 1;
                break;
            }
        }
        return account;
    }


    /**
     * @Description 生成账户id
     * @param
     * @return String
     * @Author Cunhao Fan
     * @Date 2023/5/5 19:26
     */
    public String accountId() {
        StringBuffer sb = new StringBuffer("86215021");
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
        sb.append(sf.format(new Date()));
        int indexDigit = (index+"").length();
        while (indexDigit < 4) {
            sb.append("0");
            indexDigit++;
        }
        sb.append(index);
        return sb.toString();
    }

    /**
     * @Description 用户登录
     * @param id 用户登录账户id
     * @param password 用户登录账户密码
     * @return Account 返回用户登录账户信息
     * @Author Cunhao Fan
     * @Date 2023/5/5 10:35
     */
    public Account login(long id, String password) {
        Account account = null;
        for (Account everyAccount: allAccounts
             ) {
            if (everyAccount!= null && everyAccount.getId() == id && everyAccount.getPassword().equals(password)) { //匹配账户id和密码
                account = everyAccount;
            }
        }
        if (account != null) {
            System.out.println("登陆成功！");
            while (true) {
                /*登录成功后，展示各种功能*/
                System.out.println("---------------------请选择以下服务---------------------");
                System.out.println("0：存款 1：取款 2：设置透支额度 3：转账 4：贷款 5：还贷 6: 资产排行 7：退出");
                int function = scanner.nextInt();
                switch (function) {
                    case 0: {
                        System.out.println("---------------------欢迎进入存款界面---------------------");
                        System.out.println("请输入存款金额：");
                        double money = scanner.nextDouble();
                        System.out.println(deposit(account.getId(), money));
                        break;
                    }
                    case 1: {
                        System.out.println("---------------------欢迎进入取款界面---------------------");
                        System.out.println("请输入取款金额：");
                        double money = scanner.nextDouble();
                        System.out.println(withdraw(account.getId(), account.getPassword(), money));;
                        break;
                    }
                    case 2: {
                        System.out.println("---------------------欢迎进入设置透支额度界面---------------------");
                        if (account instanceof CreditAccount) {
                        System.out.println("请输入透支额度：");
                        double ceiling = scanner.nextDouble();
                        System.out.println(updateCeiling(account.getId(), account.getPassword(), ceiling));
                        }else {
                            System.out.println("当前账户不是信用账户！");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("---------------------欢迎进入转账界面---------------------");
                        System.out.println("请输入转入账户id");
                        int targetid = scanner.nextInt();
                        System.out.println("请输入转账金额：");
                        double ceiling = scanner.nextDouble();
                        if(transfer(account.getId(), account.getPassword(), targetid, ceiling)) {
                            System.out.println("转账成功！");
                        }else {
                            System.out.println("转账失败！");
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("---------------------欢迎进入贷款界面---------------------");
                        if (account instanceof LoanSavingAccount || account instanceof LoanCreditAccount) {
                            System.out.println("请输入贷款金额：");
                            double money = scanner.nextDouble();
                            System.out.println(requestLoan(account.getId(), money));
                        }else {
                            System.out.println("当前账户类型不支持贷款！");
                        }
                        break;
                    }
                    case 5: {
                        System.out.println("---------------------欢迎进入还贷界面---------------------");
                        if (account instanceof LoanSavingAccount || account instanceof LoanCreditAccount) {
                            System.out.println("请输入还贷金额：");
                            double money = scanner.nextDouble();
                            System.out.println(payLoan(account.getId(), money));
                        }else {
                            System.out.println("当前账户类型不支持还款！");
                        }
                        break;
                    }
                    case 6: {
                        System.out.println("---------------------欢迎进入资产排行界面---------------------");
                        System.out.println(sortAsset());
                        break;
                    }
                    case 7:{
                        break;
                    }
                }
                break;
            }
        }else {
            System.out.println("当前账户不存在，请先注册！");
        }
        return account;
    }


    /**
     * @Description 用户存款
     * @param id 用户存款账户id
     * @param money 用户存款金额
     * @return Account 返回用户存款账户
     * @Author Cunhao Fan
     * @Date 2023/5/5 10:37
     */
    public Account deposit(long id, double money) {
        Account account = null;
        for (Account everyAccount: allAccounts
        ) {
            if (everyAccount != null && everyAccount.getId() == id) {
                account = everyAccount;
                account.setBalance(account.getBalance() + money); //更新余额
                System.out.println("存款中...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(money+"元存款成功！");
            }
        }
        return account;
    }


    /**
     * @Description 用户取款
     * @param id 取款用户账号id
     * @param password 取款用户账户密码
     * @param money 取款金额
     * @return Account 返回取款账户
     * @Author Cunhao Fan
     * @Date 2023/5/5 10:42
     */
    public Account withdraw(long id, String password, double money) {
        Account account = null;
        for (Account everyAccount: allAccounts
        ) {
            if (everyAccount != null && everyAccount.getId() == id) {
                account = everyAccount;
            }
        }
        if (account instanceof SavingAccount) {
            if (account.getBalance() >= money) {
                account.setBalance(account.getBalance() - money); //更新余额
                System.out.println("取款中...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(money+"元取款成功！");
            }
            else {
                System.out.println("取款失败，余额不足！");
            }
        }
        if (account instanceof CreditAccount) {
            if (account.getBalance() > money) {
                account.setBalance(account.getBalance() - money); //更新余额
                System.out.println("取款中...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(money+"元取款成功！");
            } else if (account.getBalance() + ((CreditAccount) account).getCeiling() > money){
                ((CreditAccount) account).setCeiling(((CreditAccount) account).getCeiling() - (money - account.getBalance()));
                account.setBalance(0);
                System.out.println("取款中...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(money+"元取款成功！");
            } else {
                System.out.println("取款失败，余额与信用额度不足！");
            }
        }
        return account;
    }


    /**
     * @Description 设置透支额度
     * @param id 设置透支额度的账户id
     * @param password 设置透支额度的账户密码
     * @param ceiling 透支额度金额
     * @return Account
     * @Author Cunhao Fan
     * @Date 2023/5/5 10:51
     */
    public Account updateCeiling(long id, String password, double ceiling) {
        CreditAccount account = null;
        for (Account everyAccount: allAccounts
        ) {
            if (everyAccount != null && everyAccount.getId() == id && everyAccount instanceof CreditAccount) { // 匹配账户并且判断账户是否为信用账户
                account = (CreditAccount) everyAccount;
                account.setCeiling(ceiling);
                System.out.println("额度设置中...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(ceiling+"元透支额度设置成功！");
                System.out.println(account);
            }
        }
        return account;
    }


    /**
     * @Description 用户转账
     * @param id 转出账户id
     * @param password 转出账户密码
     * @param targetId 目标账户id
     * @param money 转出金额
     * @return boolean 返回是否转账成功
     * @Author Cunhao Fan
     * @Date 2023/5/5 11:01
     */
    public boolean transfer(long id, String password, long targetId, double money) {
        /*假设不能成功转账*/
        boolean isSuccess = false;
        Account currentAccount = null;
        Account targetAccount = null;
        for (Account everyAccount: allAccounts
        ) {
            if (everyAccount != null && everyAccount.getId() == id && everyAccount.getPassword().equals(password)) { // 匹配账户和密码
                currentAccount = everyAccount;
            }
            if (everyAccount != null && everyAccount.getId() == targetId) { // 匹配目标账户
                targetAccount = everyAccount;
            }
        }
        if (currentAccount != null && currentAccount.getBalance() > money && targetAccount != null) {
            currentAccount.setBalance(currentAccount.getBalance() - money);
            targetAccount.setBalance(targetAccount.getBalance() + money);
            System.out.println("转账中...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(money+"元转账成功！");
            System.out.println(currentAccount);
            isSuccess = true; // 转账成功
        }
        return isSuccess;
    }


    /**
     * @Description 用户贷款
     * @param id 贷款账户
     * @param money 贷款金额
     * @return Account
     * @Author Cunhao Fan
     * @Date 2023/5/5 20:28
     */
    public Account requestLoan(long id, double money) {
        Account account = null;
        for (Account everyAccount: allAccounts
        ) {
            if (everyAccount != null && everyAccount.getId() == id) {
                account = everyAccount;
            }
        }
        if (account instanceof LoanSavingAccount) {
            ((LoanSavingAccount) account).requestLoan(money);
        }
        if (account instanceof LoanCreditAccount) {
            ((LoanCreditAccount) account).requestLoan(money);
        }
        return account;
    }


    /**
     * @Description 用户还款
     * @param id 还款账户id
     * @param money 还款金额
     * @return Account
     * @Author Cunhao Fan
     * @Date 2023/5/5 21:11
     */
    public Account payLoan(long id, double money) {
        Account account = null;
        for (Account everyAccount: allAccounts
        ) {
            if (everyAccount != null && everyAccount.getId() == id) {
                account = everyAccount;
            }
        }
        if (account instanceof LoanSavingAccount) {
            ((LoanSavingAccount) account).requestLoan(money);
        }
        if (account instanceof LoanCreditAccount) {
            ((LoanCreditAccount) account).requestLoan(money);
        }
        return account;
    }


    /**
     * @Description 统计所有账户余额总数
     * @param
     * @return double
     * @Author Cunhao Fan
     * @Date 2023/5/5 11:24
     */
    public double statisticsAllAccountBalance() {
        double allBalance = Arrays.stream(allAccounts).mapToDouble(Account::getBalance).sum();
        return allBalance;
    }


    /**
     * @Description 统计所有信用账户透支额度总数
     * @param
     * @return double
     * @Author Cunhao Fan
     * @Date 2023/5/5 11:39
     */
    public double statisticsAllSavingAccountCeiling() {
        double allCeiling = Arrays.stream(allAccounts).filter(account -> account instanceof CreditAccount).mapToDouble(account -> ((CreditAccount) account).getCeiling()).sum();
        return allCeiling;
    }


    public List<Map.Entry<String, Double>> sortAsset() {
        Map<String, Double> map = new HashMap<>();
        //ArrayList<Double> arrayList = new ArrayList<>();
        for (Account everyAccount: allAccounts
             ) {
            boolean isCan=false;//不存在
            Set<String> set=map.keySet();
            if (map.size() != 0){
                for (String everySet:set
                ) {
                    if (everyAccount != null && everySet.equals(everyAccount.getPersonId())){
                        map.put(everyAccount.getPersonId(), map.get(everySet)+everyAccount.getBalance());
                        isCan=true;
                        break;
                    }

                }
            }
            if (!isCan && everyAccount != null){
                map.put(everyAccount.getPersonId(),everyAccount.getBalance());
            }
            /*if (map.containsKey(everyAccount.getPersonId())) { // 如果Map中已经有这个键，则直接将元素放入该键对应的集合
                arrayList.add(everyAccount.getBalance());
            }
            else { // 先创建这个键再将元素放入该键对应的集合
                arrayList.add(everyAccount.getBalance());
                map.put(everyAccount.getPersonId(),arrayList);
            }*/
        }
        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return (int) ((o1.getValue() - o2.getValue())*100);
            }
        });
        return list;

    }

    /*重写toString方法*/

    @Override
    public String toString() {
        return "Bank{" +
                "allAccounts=" + Arrays.toString(allAccounts) +
                ", index=" + index +
                '}';
    }
}
