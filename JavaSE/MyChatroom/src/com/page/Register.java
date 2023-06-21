package com.page;

import com.bean.Student;
import com.service.StudentService;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName Registe
 * @Description 注册界面
 * @Author Cunhao Fan
 * @Date 2023/5/9 17:45
 * @Version 1.0
 */
public class Register extends JFrame {
    /*实例化业务逻辑层*/
    StudentService service = new StudentService();
    public Register() {
        /*初始化注册界面*/
        initRegisterUI();

        /*初始化注册界面组件*/
        initRegisterComponent();

        /*设置注册界面可见*/
        this.setVisible(true);
    }

    /**
     * @Description 初始化登录界面组件 2个JLable，2个JTextField，1个JBUtton
     * @param
     * @return void
     * @Author Cunhao Fan
     * @Date 2023/5/9 16:05
     */
    private void initRegisterComponent() {
        /*创建两个JLable分别用于显示学生学号和学生密码*/
        JLabel stuNoLable = new JLabel("学生学号：");
        JLabel stuPasswordLable = new JLabel("学生密码：");
        /*设置容器里的内容字体*/
        stuNoLable.setFont(new Font("微软雅黑", 0, 13));
        stuPasswordLable.setFont(new Font("微软雅黑", 0, 13));
        /*设置容器的位置和大小*/
        stuNoLable.setBounds(15, 50, 80, 25);
        stuPasswordLable.setBounds(15, 80, 80, 25);
        /*将两个组件添加到界面中*/
        this.getContentPane().add(stuNoLable);
        this.getContentPane().add(stuPasswordLable);

        /*创建两个文本输入框，用于输入学号和密码*/
        JTextField stuNoTextFiled = new JTextField(20);
        JPasswordField stuPasswordField = new JPasswordField(20);
        /*设置文本域的位置和大小*/
        stuNoTextFiled.setBounds(100, 50, 165, 25);
        stuPasswordField.setBounds(100, 80, 165, 25);
        /*将组件添加到界面中*/
        this.getContentPane().add(stuNoTextFiled);
        this.getContentPane().add(stuPasswordField);

        /*创建祖册按钮*/
        JButton register = new JButton("注册");
        /*设置按钮的位置和大小*/
        register.setBounds(100, 150, 80, 25);
        /*将按钮添加到界面中*/
        this.getContentPane().add(register);
        /*绑定鼠标点击事件*/
        register.addActionListener(e -> {
            String stuNo = stuNoTextFiled.getText();
            String stuPassword = stuPasswordField.getText();
            /*学号不是纯数字，弹窗警告错误*/
            if (!stuNo.matches("\\d+")) {
                initRegisterDialog("stuNo");
            }
            /*密码不是字母数字下划线，弹窗警告错误*/
            else if (!stuPassword.matches("\\w+")) {
                initRegisterDialog("stuPassword");
            }
            else {
                Student registerStudent = service.register(stuNo, stuPassword);
                if (registerStudent != null) {
                    /*注册成功*/
                    new Dialog(this);
                } else {
                    /*注册失败*/
                }
            }
        });
    }

    private void initRegisterDialog(String mess) {
        /*创建警告框*/
        Dialog registerDialog = new Dialog(this);
        /*设置警告框标题*/
        if (mess.equals("stuNo")) {
            registerDialog.setTitle("学号注册异常");
        }
        else if(mess.equals("stuPassword")){
            registerDialog.setTitle("密码注册异常");
        }
        /*设置警告框居中*/
        registerDialog.setLocationRelativeTo(null);
        /*设置警告框不可拖拽*/
        registerDialog.setResizable(false);
        /*设置警告框大小*/
        registerDialog.setSize(100, 120);
        /*设置警告框可见*/
        registerDialog.setVisible(true);
    }

    /**
     * @Description 初始化登录界面
     * @param
     * @return void
     * @Author Cunhao Fan
     * @Date 2023/5/9 16:00
     */
    private void initRegisterUI() {
        /*设置界面的名称*/
        this.setTitle("学生聊天室注册界面 v1.0");
        /*设置界面的宽高*/
        this.setSize(300, 400);
        /*设置界面的居中方式*/
        this.setLocationRelativeTo(null);
        /*设置不可拖拽*/
        this.setResizable(false);
        /*设置界面的关闭模式*/
        this.setDefaultCloseOperation(2);
        /*设置界面置顶*/
        this.setAlwaysOnTop(true);
        /*设置界面的布局*/
        this.setLayout(null);
    }
}
