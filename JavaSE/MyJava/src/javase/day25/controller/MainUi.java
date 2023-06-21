package javase.day25.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @packageName javase.day25.entity
 * @ClassName ATM_GUI
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/5/23 10:26
 * @Version 1.0
 */
public class MainUi extends JFrame {
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
    final String CHINESE = "chinese";
    final String ENGLISH = "english";
    /**
     * 默认页面显示中文
     */
    String languageChoose = CHINESE;

    public MainUi() throws HeadlessException {
        /*初始化界面*/
        initUi();
        /*初始化组件*/
        initComponent();

        /*设置界面可见*/
        this.setVisible(true);
    }

    public void initComponent() {
        /*定义两个按钮*/
        JButton load, register;
        load = new JButton("登录");
        load.setBounds(46, 180, 80, 30);
        this.getContentPane().add(load);
        /*添加点击事件*/
        load.addActionListener(e -> {
            this.setVisible(false);
            new Login(languageChoose);
        });
        register = new JButton("注册");
        register.setBounds(160, 180, 80, 30);
        this.getContentPane().add(register);
        /*添加点击事件*/
        register.addActionListener(e -> {
            this.setVisible(false);
            new Register(languageChoose);
        });

        /*定义下拉框的内容*/
        String[] language = {"中文", "english"};
        /*定义下拉框*/
        JComboBox<String> jComboBox = new JComboBox<>(language);
        /*设置下拉框的位置和大小*/
        jComboBox.setBounds(20, 20, 80, 25);
        /*将下拉框添加到界面中*/
        this.getContentPane().add(jComboBox);
        /*给下拉框添加点击事件*/
        jComboBox.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*获取下拉框的值*/
                String choose = (String) jComboBox.getSelectedItem();
                Locale locale = null;
                if (language[0].equals(choose)) {
                    locale = new Locale("zh", "CN");
                } else if (language[1].equals(choose)) {
                    locale = new Locale("en", "US");
                    languageChoose = ENGLISH;
                }
                ResourceBundle resourceBundle = null;
                if (locale != null) {
                    resourceBundle = ResourceBundle.getBundle("language", locale);
                }
                load.setText(resourceBundle.getString("load"));
                register.setText(resourceBundle.getString("register"));
                setTitle(resourceBundle.getString("mainTitle"));
            }
        });
    }

    /**
     * 初始化界面
     */
    public void initUi() {
        /*设置界面标题*/
        this.setTitle("自助取款机主界面 v1.0");
        /*设置界面宽高*/
        this.setSize(300, 400);
        /*设置界面置顶*/
        this.setAlwaysOnTop(true);
        /*设置界面的默认关闭方式*/
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*设置以左上角为原点的坐标轴布局*/
        this.setLayout(null);
        /*设置界面居中*/
        this.setLocationRelativeTo(null);
        /*设置界面不可拖拽*/
        this.setResizable(false);
    }
}
