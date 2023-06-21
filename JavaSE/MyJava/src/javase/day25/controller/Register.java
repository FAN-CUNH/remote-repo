package javase.day25.controller;

import javase.day25.service.AccountService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @packageName javase.day25.controller
 * @ClassName Register
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/5/23 18:26
 * @Version 1.0
 */
public class Register extends JFrame {
    final String CHINESE = "chinese";
    String languageType;
    public Register(String language) throws HeadlessException {
        languageType = language;
        /*初始化界面*/
        initRegister();
        /*初始化组件*/
        initRegisterComponent();
        /*设置界面可见*/
        this.setVisible(true);
    }

    private void initRegister() {
        /*设置界面的名称*/
        this.setTitle("自助ATM注册界面 v1.0");
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

    private void initRegisterComponent() {
        Locale locale;
        if (CHINESE.equals(languageType)) {
            locale = new Locale("zh", "CN");
        } else {
            locale = new Locale("en", "US");
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("language", locale);
        this.setTitle(resourceBundle.getString("registerTitle"));
        /*创建两个JLable分别用于显示账号和密码*/
        JLabel idLabel = new JLabel(resourceBundle.getString("userId"));
        JLabel passwordLabel = new JLabel(resourceBundle.getString("password"));
        JLabel nameLabel = new JLabel(resourceBundle.getString("userName"));
        JLabel personIdLabel = new JLabel(resourceBundle.getString("personId"));
        JLabel emailLabel = new JLabel(resourceBundle.getString("email"));
        JLabel balanceLabel = new JLabel(resourceBundle.getString("balance"));
        JLabel typeLabel = new JLabel(resourceBundle.getString("type"));

        /*设置容器里的内容字体*/
        idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        passwordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        personIdLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        emailLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        balanceLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        typeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        /*设置容器的位置和大小*/
        idLabel.setBounds(15, 50, 80, 25);
        passwordLabel.setBounds(15, 80, 80, 25);
        nameLabel.setBounds(15, 110, 80, 25);
        personIdLabel.setBounds(15, 140, 80, 25);
        emailLabel.setBounds(15, 170, 80, 25);
        balanceLabel.setBounds(15, 200, 80, 25);
        typeLabel.setBounds(15, 20, 80, 25);
        /*将两个组件添加到界面中*/
        Container pane = this.getContentPane();
        pane.add(idLabel);
        pane.add(passwordLabel);
        pane.add(nameLabel);
        pane.add(personIdLabel);
        pane.add(emailLabel);
        pane.add(balanceLabel);
        pane.add(typeLabel);

        /*创建两个文本输入框，用于输入学号和密码*/
        JTextField idTextFiled = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JTextField nameTextFiled = new JTextField(20);
        JTextField personIdTextFiled = new JTextField(20);
        JTextField emailTextFiled = new JTextField(20);
        JTextField balanceTextFiled = new JTextField(20);
        /*设置文本域的位置和大小*/
        idTextFiled.setBounds(100, 50, 165, 25);
        passwordField.setBounds(100, 80, 165, 25);
        nameTextFiled.setBounds(100, 110, 165, 25);
        personIdTextFiled.setBounds(100, 140, 165, 25);
        emailTextFiled.setBounds(100, 170, 165, 25);
        balanceTextFiled.setBounds(100, 200, 165, 25);
        /*将组件添加到界面中*/
        pane.add(idTextFiled);
        pane.add(passwordField);
        pane.add(nameTextFiled);
        pane.add(personIdTextFiled);
        pane.add(emailTextFiled);
        pane.add(balanceTextFiled);

        /*创建信用额度的组件*/
        JLabel ceilingLabel = new JLabel(resourceBundle.getString("ceiling"));
        ceilingLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        ceilingLabel.setBounds(15, 230, 80, 25);
        JTextField ceilingTextFiled = new JTextField(20);
        ceilingTextFiled.setBounds(100, 230, 165, 25);
        pane.add(ceilingLabel);
        pane.add(ceilingTextFiled);
        ceilingLabel.setVisible(false);
        ceilingTextFiled.setVisible(false);

        /*创建下拉框*/
        JComboBox<String> jComboBox = new JComboBox<String>();
        /*添加下拉框选项*/
        jComboBox.addItem(resourceBundle.getString("save"));
        jComboBox.addItem(resourceBundle.getString("credit"));
        /*设置下拉框的位置和大小*/
        jComboBox.setBounds(100, 20, 165, 25);
        /*将下拉框添加到界面中*/
        this.getContentPane().add(jComboBox);
        /*给下拉框添加事件*/
        jComboBox.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*获取下拉框的值*/
                String choose = (String) jComboBox.getSelectedItem();
                System.out.println(choose);
                /*修改信用额度组件是否可见*/
                if (resourceBundle.getString("save").equals(choose)) {
                    ceilingLabel.setVisible(false);
                    ceilingTextFiled.setVisible(false);
                }
                else {
                    ceilingLabel.setVisible(true);
                    ceilingTextFiled.setVisible(true);
                }
            }
        });
        /*创建注册按钮*/
        JButton register = new JButton(resourceBundle.getString("register"));
        /*设置按钮的位置和大小*/
        register.setBounds(100, 270, 80, 25);
        /*将按钮添加到界面中*/
        this.getContentPane().add(register);
        /*绑定鼠标点击事件*/
        register.addActionListener(e -> {
            /*调用业务逻辑层*/
            AccountService accountService = new AccountService();
            /*获取文本框中的值*/
            int id = Integer.parseInt(idTextFiled.getText());
            String password = passwordField.getText();
            String name = nameTextFiled.getText();
            String personId = personIdTextFiled.getText();
            String email = emailTextFiled.getText();
            double balance = Double.parseDouble(balanceTextFiled.getText());
            double ceiling = 0;
            /*获取下拉框的值*/
            String typeString = (String) jComboBox.getSelectedItem();
            if (resourceBundle.getString("save").equals(typeString)) {
                accountService.savingAccountRegister(id, password, name, personId, email, balance);
                this.setVisible(false);
                new Login(languageType);
            }
            else {
                ceiling = Double.parseDouble(ceilingTextFiled.getText());
                System.out.println(ceiling);
                accountService.creditAccountRegister(id, password, name, personId, email, balance, ceiling);
                this.setVisible(false);
                new Login(languageType);
            }
        });
    }
}
