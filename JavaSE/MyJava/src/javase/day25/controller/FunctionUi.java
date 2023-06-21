package javase.day25.controller;

import javase.day25.entity.Account;
import javase.day25.service.AccountService;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

/**
 * @packageName javase.day25.controller
 * @ClassName FunctionUi
 * @Description 功能界面
 * @Author CunHao Fan
 * @Date 2023/5/27 14:34
 * @Version 1.0
 */
public class FunctionUi extends JFrame {
    /**
     * Constructs a new frame that is initially invisible.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     * returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     * @see JComponent#getDefaultLocale
     */
    AccountService accountService = new AccountService();
    Scanner scanner = new Scanner(System.in);
    static int rankNumber = 1;
    static int b=0;
    String languageType;
    final String CHINESE = "chinese";

    public FunctionUi(String accountId, String accountType, String language) throws HeadlessException {
        languageType = language;
        /*初始化界面*/
        initUi();
        /*初始化组件*/
        initUnit();
        /*初始化事件*/
        initEvent(accountId, accountType);

        /*设置界面可见*/
        this.setVisible(true);
    }

    /**
     * 声明存款，取款，转账所需的组件
     */
    JDialog dialog;
    JLabel tip;
    JTextField textField;
    JButton sure, exit;

    /**
     * 初始化存款，取款所需的组件
     *
     * @param function 需求名
     */
    public void initWDUnit(String function) {
        /*创建ATM功能对话框*/
        dialog = new JDialog(this, function + "对话框");
        /*设置对话框居中显示*/
        dialog.setLocationRelativeTo(null);
        /*设置对话框不可拖拽大小*/
        dialog.setResizable(false);
        /*设置对话框置顶显示*/
        dialog.setAlwaysOnTop(true);
        /*设置对话框大小*/
        dialog.setSize(300, 200);
        /*创建输入取款金额提示文本框*/
        tip = new JLabel("请输入" + function + "金额");
        /*设置提示文本框中的文字居中显示*/
        tip.setHorizontalAlignment(SwingConstants.CENTER);
        /*设置提示文本框的大小和位置*/
        tip.setBounds(85, 20, 100, 30);
        /*将提示文本框添加到对话框中*/
        dialog.add(tip);
        /*创建功能金额文本输入框*/
        textField = new JTextField();
        /*设置功能金额输入框中的文字居中显示*/
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        /*设置功能金额输入框的大小和位置*/
        textField.setBounds(90, 50, 100, 30);
        /*设值对话框的布局方式为坐标轴布局*/
        dialog.setLayout(null);
        /*将功能金额输入框添加到对话框中*/
        dialog.add(textField);
        /*创建确定按钮*/
        sure = new JButton(function);
        /*设置确定按钮的大小和位置*/
        sure.setBounds(60, 100, 70, 30);
        /*将确定按钮添加到对话框中*/
        dialog.add(sure);
        /*创建取消按钮*/
        exit = new JButton("取消");
        /*设置取消按钮的大小和位置*/
        exit.setBounds(160, 100, 70, 30);
        /*将取消按钮添加到对话框中*/
        dialog.add(exit);
    }

    /**
     * @param accountId   账户号码
     * @param accountType 账户类型
     */
    static int i = 0;

    String[][] rankArray = new String[100][4];

    public void initEvent(String accountId, String accountType) {
        /*获取排名事件*/
        rank.addActionListener(e -> {
            accountService.rank().forEach(account -> {
                String[] row = new String[4];
                row[0] = "第" + ++i + "名";
                row[1] = String.valueOf(account.getId());
                row[2] = String.valueOf(account.getName());
                row[3] = String.valueOf(account.getBalance());
                rankArray[b++] = row;
            });
            JFrame f = new JFrame("资产排名");
            f.setSize(400, 300);
            f.setLocation(200, 200);
            f.setLayout(new BorderLayout());
            String[] columnNames = new String[]{"排名", "账户", "用户名", "资产"};
            JTable rankTable = new JTable(rankArray, columnNames);
            f.add(rankTable.getTableHeader(),BorderLayout.PAGE_START);
            f.add(rankTable, BorderLayout.CENTER);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
        /*取款事件*/
        withdraw.addActionListener(e -> {
            initWDUnit("取款");
            /*设置对话框可见*/
            dialog.setVisible(true);
            /*创建确定按钮的点击监听事件*/
            sure.addActionListener(e1 -> {
                /*获取取款金额输入框中的值，并将其转换成double类型*/
                double money = Double.parseDouble(textField.getText().toString());
                /*取款成功将取款金额输入框文本设置成"成功取款!"*/
                if (accountService.withdraw(accountId, accountType, money)) {
                    textField.setText("取款成功！");
                } else {
                    textField.setText("取款失败！");
                }
                /*创建仅执行一次的定时任务*/
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        /*将取款金额输入框中的文本设置为空白*/
                        textField.setText("");
                    }
                };
                Timer timer = new Timer();
                /*定时任务*/
                timer.schedule(timerTask, 1000);
            });
            exit.addActionListener(e1 -> {
                dialog.setVisible(false);
            });
        });
        /*存款事件*/
        deposit.addActionListener(e -> {
            initWDUnit("存款");
            /*设置对话框可见*/
            dialog.setVisible(true);
            /*创建确定按钮的点击监听事件*/
            sure.addActionListener(e1 -> {
                /*获取存款金额输入框中的值，并将其转换成double类型*/
                double money = Double.parseDouble(textField.getText().toString());
                /*调用存款方法*/
                accountService.deposit(accountId, accountType, money);
                /*取款成功将存款金额输入框文本设置成"存款成功!"*/
                textField.setText("存款成功！");
                /*创建仅执行一次的定时任务*/
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        /*将存款金额输入框中的文本设置为空白*/
                        textField.setText("");
                    }
                };
                Timer timer = new Timer();
                /*定时任务*/
                timer.schedule(timerTask, 1000);
            });
            exit.addActionListener(e1 -> {
                dialog.setVisible(false);
            });
        });
        /*转账事件*/
        transfer.addActionListener(e -> {
            System.out.println("转账");
            System.out.println("请输入目标账户、目标账户类型和金额");
            String s1 = scanner.next();
            String s2 = scanner.next();
            double d = scanner.nextDouble();
            boolean isTransfer = accountService.transfer(accountId, accountType, s1, s2, d);
            if (isTransfer) {
                System.out.println(d + "转账成功！");
            } else {
                System.out.println(d + "转账失败！");
            }
        });
        /*获取登录人信息事件*/
        mess.addActionListener(e -> {
            System.out.println(accountService.getMess(accountId, accountType));
        });
        /*获取操作记录事件*/
        operate.addActionListener(e -> {
            System.out.println(accountService.getPage(1, 3));
        });
    }

    JButton rank, withdraw, deposit, transfer, mess, operate;

    public void initUnit() {
        /*国际化*/
        Locale locale;
        if (CHINESE.equals(languageType)) {
            locale = new Locale("zh", "CN");
        } else {
            locale = new Locale("en", "US");
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("language", locale);
        /*
         *   需求                 所需组件
         * 0 标题                 JLable
         * 1 获取银行资产排名       排名按钮 以及排名弹出框
         * 2 取款                 取款按钮 以及取款界面
         * 3 存款                 存款按钮 以及存款界面
         * 4 转账                 转账按钮 以及转账界面
         * 5 查看当前账户信息       查询按钮 以及弹出账号信息界面
         * 6 操作记录              记录按钮 以及分也展示操作记录信息
         */
        /*创建JLable*/
        JLabel title = new JLabel(resourceBundle.getString("functionText1"));
        JLabel description = new JLabel(resourceBundle.getString("functionText2"));
        /*设置组件的字体*/
        title.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        description.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        description.setHorizontalAlignment(SwingConstants.CENTER);
        /*设置组件大小和位置*/
        title.setBounds(-10, 20, 300, 30);
        description.setBounds(-10, 40, 300, 30);
        /*将组件添加到界面中*/
        this.getContentPane().add(title);
        this.getContentPane().add(description);
        /*创建四个按钮*/
        withdraw = new JButton(resourceBundle.getString("withdraw"));
        deposit = new JButton(resourceBundle.getString("deposit"));
        transfer = new JButton(resourceBundle.getString("transfer"));
        rank = new JButton(resourceBundle.getString("assetRank"));
        mess = new JButton(resourceBundle.getString("viewInformation"));
        operate = new JButton(resourceBundle.getString("operationsRecord"));
        /*设置按钮的大小和位置*/
        withdraw.setBounds(30, 100, 100, 25);
        deposit.setBounds(30, 150, 100, 25);
        transfer.setBounds(30, 200, 100, 25);
        rank.setBounds(150, 100, 100, 25);
        mess.setBounds(150, 150, 100, 25);
        operate.setBounds(150, 200, 100, 25);
        /*将按钮添加到界面中*/
        this.getContentPane().add(rank);
        this.getContentPane().add(withdraw);
        this.getContentPane().add(deposit);
        this.getContentPane().add(transfer);
        this.getContentPane().add(mess);
        this.getContentPane().add(operate);
    }

    public void initUi() {
        /*设置界面标题*/
        setTitle("ATM服务功能界面");
        /*设置界面大小*/
        setSize(300, 400);
        /*设置界面居中*/
        this.setLocationRelativeTo(null);
        /*设置界面不可拖拽大小*/
        this.setResizable(false);
        /*设置界面关闭方式*/
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*设置界面置顶*/
        this.setAlwaysOnTop(true);
        /*设置界面布局*/
        this.setLayout(null);
    }
}
