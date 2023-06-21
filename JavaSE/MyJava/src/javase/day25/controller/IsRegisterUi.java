package javase.day25.controller;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @packageName javase.day25.controller
 * @ClassName IsRegister
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/5/27 16:35
 * @Version 1.0
 */
public class IsRegisterUi extends JFrame {
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
    String languageType;

    public IsRegisterUi(String language) throws HeadlessException {
        languageType = language;
        /*初始化界面*/
        initUi();
        /*初始化组件*/
        initUnit();
        /*初始化事件*/
        yes.addActionListener(e -> {
            /*跳转到注册页面，当前页面消失*/
            this.setVisible(false);
            new Register(language);
        });
        no.addActionListener(e -> {
            /*退出程序，当前页面消失*/
            this.setVisible(false);
            System.exit(1);
        });
        /*设置界面可见*/
        this.setVisible(true);
    }

    JRadioButton yes, no;

    public void initUnit() {
        /*
         *  需求        组件
         * 0 标题      JLable
         * 1 是       JRadioButton
         * 2 否       JRadioButton
         */
        /*创建标题组件，为其设置大小和位置，以及字体*/
        /*国际化*/
        Locale locale;
        if (languageType.equals(CHINESE)) {
            locale = new Locale("zh", "CN");
        } else {
            locale = new Locale("en", "US");
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("language", locale);
        JLabel title = new JLabel(resourceBundle.getString("text1"));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(-10, 80, 500, 50);
        title.setFont(new Font("楷体", Font.PLAIN, 14));
        /*创建两个单选按钮,并设置其大小和位置以及字体*/
        yes = new JRadioButton(resourceBundle.getString("yes"));
        no = new JRadioButton(resourceBundle.getString("no"));
        yes.setFont(new Font("楷体", Font.PLAIN, 13));
        no.setFont(new Font("楷体", Font.PLAIN, 13));
        yes.setBounds(150, 120, 50, 25);
        no.setBounds(300, 120, 50, 25);
        /*创建按钮组*/
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(yes);
        buttonGroup.add(no);
        /*将组件添加到界面中*/
        this.getContentPane().add(title);
        this.getContentPane().add(yes);
        this.getContentPane().add(no);
    }

    public void initUi() {
        /*设置界面标题*/
        setTitle("ATM服务功能界面");
        /*设置界面大小*/
        setSize(500, 400);
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
