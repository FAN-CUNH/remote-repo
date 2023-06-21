package javase.day6.work.bank;

public class Bank {
    /*取款机类型专门用来操作账户，可进行开户,登录操作(登录成功后，可进行取款,存款,转账,操作,设置额度...)*/
    /*声明一个静态的Account类型数组用于存储已经开户的账户信息,声明一个静态计数器用于统计已经开户的账户数,声明一个私有的静态的int类型的id用做银行卡号*/
    static Account[] accounts;
    private static int countAccount;
    private static int accountId;

    /*构造方法*/
    /*只有当Account类数组为空的时候将其实例化且只实例化一次,假设一个数组只能存放100个账户*/
    public Bank() {
        if (Bank.accounts == null){
            accounts = new Account[100];
        }
    }

    /*开户操作*/
    /*需求：同一人在当前银行只能有且仅有一张储蓄卡和信用卡*/
    /*先判断当前用户是否在数组中，根据其拥有的卡类型，决定其能否开户*/
    public Account regedit(String type,String name,int personId,String password){
        /*在此处声明一个账户，用来存储要开户人的账户信息*/
        Account account = null;
        /*假设这个人可以开户*/
        boolean isRegedit = true;
        /*验证假设：根据此人的personId和要开户的类型是否和账户数组中的数据匹配判断其能否开户*/
        for (int i = 0; i < Bank.countAccount; i++) {
            /*取出账户数组中的每一个账户对象*/
            Account account1 = accounts[i];
            /*如果当前开户人的信息与数组对象的信息完全匹配则不能开户*/
            if (personId == account1.getPersonId() && type.equals("0") && account1 instanceof SavingAccount){
                isRegedit = false;
                System.out.println("你已经在本行有存储账户卡了");
                break;
            }else if (personId == account1.getPersonId() && type.equals("1") && account1 instanceof CreditAccount){
                isRegedit = false;
                System.out.println("你已经在本行有信用账户卡了");
                break;
            }
        }
        /*根据isRegedit判断其能否开户，再type判断其开户类型,"0":储蓄开,"1"：信用卡*/
        if (isRegedit){
            if (type.equals("0")){
                /*储蓄类型，实例化储蓄对象*/
                account = new SavingAccount(0,name,personId,password);
                /*分发卡号,卡号从1开始*/
                account.setAccountId(Bank.accountId+=1);
                /*将当前开户人信息存入数组*/
                accounts[countAccount] = account;
                countAccount++;
                System.out.println("开通储蓄账户成功");
            }else if (type.equals("1")){
                /*步骤同上*/
                account = new CreditAccount(0,name,personId,password,0);
                account.setAccountId(Bank.accountId+=1);
                accounts[countAccount] = account;
                countAccount++;
                System.out.println("开通信用账户成功");
            }else {
                System.out.println("没有该类账户");
            }

        }
        return account;
    }

    /*登录操作*/
    /*根据接收的账户id和密码去数组中匹配，将其相关信息打印出来*/
    public Account load(int accountId,String password){
        /*声明一个账户类型accountLoad用来存储登录账户信息*/
        Account accountLoad = null;
        for (int i = 0; i < countAccount; i++) {
            /*声明account用来暂时保存数组中的每一个账户对象*/
            Account account = accounts[i];
            /*信息完全，地址传递*/
            if (account.getAccountId() == accountId && account.getPassword().equals(password)){
                accountLoad = account;
                break;
            }
        }
        /*若accountLoad账户不为空，即登录成功，根据登录账户判断其账户类型*/
        if (accountLoad != null){
            if (accountLoad instanceof SavingAccount){
                System.out.println("登录成功,当前账户信息："+accountLoad);
            }else if (accountLoad instanceof CreditAccount){
                System.out.println("登录成功,当前账户信息："+accountLoad);
            }
        }else {
            System.out.println("登录失败");
        }
     return accountLoad;
    }

    /*存款，取款，转账，设置信用额度*/
    /*存款:用卡号匹配账户，更新余额*/
    public void deposit(int accountId,double money){
        for (int i = 0; i < countAccount; i++) {
            if (accounts[i].getAccountId() == accountId){
                Account account = accounts[i];
                /*判断当前账户类型，信用卡账户额外打印信用额度*/
                if (account instanceof SavingAccount){
                    account.setBalance(account.getBalance()+money);
                    System.out.println(money+"元存款成功,当前账户余额："+account.getBalance());
                }else if (account instanceof CreditAccount){
                    account.setBalance(account.getBalance()+money);
                    System.out.println(money+"元存款成功,当前账户余额："+account.getBalance()+",信用额度："+((CreditAccount) account).getCredits());
                }
            }
        }
    }
    /*取款:同存款*/
    public void withdraw(int accountId,double money){
        for (int i = 0; i < countAccount; i++) {
            if (accounts[i].getAccountId() == accountId){
                Account account = accounts[i];
                /*判断当前账户类型，信用卡账户额外打印信用额度*/
                if (account instanceof SavingAccount){
                    account.setBalance(account.getBalance()-money);
                    System.out.println(money+"元存款成功,当前账户余额："+account.getBalance());
                }else if (account instanceof CreditAccount){
                    /*信用卡取款：若取款总额大于当前卡余额则先用余额再用信用额*/
                    if (money > account.getBalance() && money < account.getBalance()+((CreditAccount) account).getCredits()){
                        ((CreditAccount) account).setCredits(((CreditAccount) account).getCredits()-(money-account.getBalance()));
                        account.setBalance(0);
                        System.out.println(money+"元取款成功,当前账户余额："+account.getBalance()+",信用额度："+((CreditAccount) account).getCredits());
                    }else if (money < account.getBalance()){
                        account.setBalance(account.getBalance()-money);
                        System.out.println(money+"元存款成功,当前账户余额："+account.getBalance()+",信用额度："+((CreditAccount) account).getCredits());
                    }else {
                        System.out.println("信用额度不足");
                    }
                }
            }
        }
    }
    /*转账：接收两个accountId,一个是当前账户，另一个是目标账户*/
    public void transfer(int accountId,int targetaccountId,double money){
        /*声明两个账户*/
        Account account = null;
        Account targetaccount = null;
        for (int i = 0; i < countAccount; i++) {
            if (accounts[i].getAccountId() == accountId){
                account = accounts[i];
                break;
            }
        }
        for (int i = 0; i < countAccount; i++) {
            if (accounts[i].getAccountId() == targetaccountId){
                targetaccount = accounts[i];
                break;
            }
        }
        if (account != null && targetaccount != null){
            /*当前账户余额-money，目标账户+money*/
            account.setBalance(account.getBalance() - money);
            targetaccount.setBalance(targetaccount.getBalance()+money);
            if (account instanceof CreditAccount){
                System.out.println(money+"转账成功"+"当前账户余额："+account.getBalance()+"信用额度："+((CreditAccount) account).getCredits());
            }else {
                System.out.println(money+"转账成功"+"当前账户余额："+account.getBalance());
            }
        }
    }


    /*设置信用额度*/
    public void setCredit(int accountId,double money){
        for (int i = 0; i < countAccount; i++) {
            if (accounts[i].getAccountId() == accountId){
                Account account = accounts[i];
                /*判断当前账户类型，信用卡账户额外打印信用额度*/
                if (account instanceof SavingAccount){
                    System.out.println("储蓄卡");
                }else if (account instanceof CreditAccount){
                    ((CreditAccount) account).setCredits(money);
                    System.out.println("信用额度设置成功，当前信用额度为："+((CreditAccount) account).getCredits());
                }
            }
        }
    }


}
