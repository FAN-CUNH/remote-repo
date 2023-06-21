package javase.day25.controller;

import javase.day25.entity.Account;
import javase.day25.entity.CreditAccount;
import javase.day25.entity.SavingAccount;
import javase.day25.service.AccountService;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @packageName javase.day25.controller
 * @ClassName Login
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/5/23 18:14
 * @Version 1.0
 */
public class Login extends JFrame {
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
    Scanner scanner = new Scanner(System.in);
    final String CHINESE = "chinese";
    final String[] SAVE = {"savingAccount", "储蓄账户"};
    final String[] CREDIT = {"creditAccount", "信用账户"};
    String languageType;

    public Login(String language) throws HeadlessException {
        languageType = language;
        /*初始化界面*/
        initLogin();
        /*初始化组件*/
        initLoginComponent();
        /*设置界面可见*/
        this.setVisible(true);
    }

    private void initLogin() {
        /*设置界面的名称*/
        this.setTitle("自助取款机登录界面 v1.0");
        /*设置界面的宽高*/
        this.setSize(300, 400);
        /*设置界面的居中方式*/
        this.setLocationRelativeTo(null);
        /*设置不可拖拽*/
        this.setResizable(false);
        /*设置界面的关闭模式*/
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*设置界面置顶*/
        this.setAlwaysOnTop(true);
        /*设置界面的布局*/
        this.setLayout(null);
    }

    private void initLoginComponent() {
        /*创建两个JLable分别用于显示学生学号和学生密码*/
        JLabel id = new JLabel();
        JLabel password = new JLabel();
        JLabel type = new JLabel();
        Locale locale;
        if (CHINESE.equals(languageType)) {
            System.out.println(1);
            locale = new Locale("zh", "CN");
        } else {
            System.out.println(2);
            locale = new Locale("en", "US");
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("language", locale);
        this.setTitle(resourceBundle.getString("loginTitle"));
        id.setText(resourceBundle.getString("userId"));
        password.setText(resourceBundle.getString("password"));
        type.setText(resourceBundle.getString("type"));
        /*设置容器里的内容字体*/
        id.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        password.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        type.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        /*设置容器的位置和大小*/
        id.setBounds(15, 50, 80, 25);
        password.setBounds(15, 80, 80, 25);
        type.setBounds(15, 110, 80, 25);
        /*将两个组件添加到界面中*/
        this.getContentPane().add(id);
        this.getContentPane().add(password);
        this.getContentPane().add(type);

        /*创建两个文本输入框，用于输入学号和密码*/
        JTextField idTextFiled = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        /*设置文本域的位置和大小*/
        idTextFiled.setBounds(100, 50, 165, 25);
        passwordField.setBounds(100, 80, 165, 25);
        /*将组件添加到界面中*/
        this.getContentPane().add(idTextFiled);
        this.getContentPane().add(passwordField);

        /*创建下拉框*/
        JComboBox<String> jComboBox = new JComboBox<String>();
        /*添加下拉框选项*/
        jComboBox.addItem(resourceBundle.getString("save"));
        jComboBox.addItem(resourceBundle.getString("credit"));
        /*设置下拉框的位置和大小*/
        jComboBox.setBounds(100, 110, 165, 25);
        /*将下拉框添加到界面中*/
        this.getContentPane().add(jComboBox);

        /*创建登录按钮*/
        JButton login = new JButton(resourceBundle.getString("load"));
        /*设置按钮的位置和大小*/
        login.setBounds(100, 180, 80, 25);
        /*将按钮添加到界面中*/
        this.getContentPane().add(login);
        /*绑定鼠标点击事件*/
        login.addActionListener(e -> {

            /*调用业务逻辑层*/
            AccountService accountService = new AccountService();
            /*获取下拉框的值*/
            String typeString = (String) jComboBox.getSelectedItem();
            /*获取文本框中的值*/
            String idString = idTextFiled.getText();
            String passwordString = passwordField.getText();
            System.out.println(resourceBundle.getString("type") + ":  " + typeString + "  " + resourceBundle.getString("userId") +":  "+ idString+ "  "  + resourceBundle.getString("password") +":  "+ passwordString);
            Account account = null;
            /*将国际化的值变回中文，方便方法中判断账户类型*/
            if (SAVE[0].equals(typeString)) {
                typeString = SAVE[1];
            }
            else if (CREDIT[0].equals(typeString)){
                typeString = CREDIT[1];
            }
            /*储蓄账户登录*/
            if (accountService.login(idString, passwordString, typeString) instanceof SavingAccount) {
                account = accountService.login(idString, passwordString, typeString);
                System.out.println("登录人信息：" + (SavingAccount) account);
            }
            /*信用账户登录*/
            else if (accountService.login(idString, passwordString, typeString) instanceof CreditAccount) {
                account = accountService.login(idString, passwordString, typeString);
                System.out.println("登录人信息：" + (CreditAccount) account);
            }
            if (account != null) {
                /*登录成功,本界面隐藏*/
                this.setVisible(false);
                /*跳转到功能界面*/
                new FunctionUi(idString, typeString ,languageType);
            } else {
                /*登录失败，本界面隐藏，提示注册*/
                this.setVisible(false);
                /*跳转到是否注册页面*/
                new IsRegisterUi(languageType);
            }
        });
    }
}
