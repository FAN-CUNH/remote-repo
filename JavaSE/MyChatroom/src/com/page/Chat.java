package com.page;

import com.service.StudentService;

import javax.swing.*;

/**
 * @ClassName Chat
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/9 17:45
 * @Version 1.0
 */
public class Chat extends JFrame {
    /*实例化业务逻辑层*/
    StudentService service = new StudentService();
    public Chat() {
        /*初始化注册界面*/
        initChatUI();

        /*初始化注册界面组件*/
        initChatComponent();

        /*设置注册界面可见*/
        this.setVisible(true);
    }

    private void initChatComponent() {
        /*创建一个文本域*/
        JTextArea chatArea = new JTextArea();
        /*设置文本域的位置和大小*/
        chatArea.setBounds(15, 50, 250, 180);
        /*将文本域添加到聊天界面*/
        this.getContentPane().add(chatArea);
        /*创建2个发送按钮*/
        JButton sendButton = new JButton("发送");
        JButton receiveButton = new JButton("接收");
        /*设置按钮的位置和大小*/
        sendButton.setBounds(185, 250, 80, 25);
        receiveButton.setBounds(15, 250, 80, 25);

        /*将2个按钮添加到界面中*/
        this.getContentPane().add(sendButton);
        this.getContentPane().add(receiveButton);
        /*绑定鼠标点击事件*/
        sendButton.addActionListener(e -> {
            service.sendMess(chatArea.getText());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            chatArea.setText("发送成功！");
        });
        /*绑定鼠标点击事件*/
        receiveButton.addActionListener(e -> {
            chatArea.setText("接收信息中...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            String mess = service.receiveMess();
            chatArea.setText(mess);
        });
    }

    /**
     * @Description 聊天界面
     * @param
     * @return void
     * @Author Cunhao Fan
     * @Date 2023/5/9 19:08
     */
    private void initChatUI() {
        /*设置界面的名称*/
        this.setTitle("学生聊天室界面 v1.0");
        /*设置界面的宽高*/
        this.setSize(300, 400);
        /*设置界面的居中方式*/
        this.setLocationRelativeTo(null);
        /*设置不可拖拽*/
        this.setResizable(false);
        /*设置界面的关闭模式*/
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        /*设置界面置顶*/
        this.setAlwaysOnTop(true);
        /*设置界面的布局*/
        this.setLayout(null);
    }
}
