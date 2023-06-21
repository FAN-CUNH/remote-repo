package com.puzzle_game.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.Random;

/**
 * @ClassName GameJFrame
 * @Description 游戏界面
 * @Author Cunhao Fan
 * @Date 2023/5/7 19:31
 * @Version 1.0
 */
public class GameJFrame extends JFrame{
    /*创建一个二维数组,加载图片的时候以二维数组中的数据进行加载*/
    int[][] data = new int[4][4];
    /*构造方法*/
    public GameJFrame() throws HeadlessException {
        /*初始化界面*/
        initJFrame();

        /*初始化菜单*/
        initJMenuBar();

        /*初始化数据*/
        initDate();

        /*初始化图片*/
        initJLable();

        /*设置界面可见*/
        this.setVisible(true);
    }

    /**
     * @Description 初始化界面
     * @param
     * @return void
     * @Author Cunhao Fan
     * @Date 2023/5/7 20:03
     */
    public void initJFrame() {
        /*设置界面的标题*/
        this.setTitle("拼图单机版 v1.0");
        /*设置界面置顶*/
        this.setAlwaysOnTop(true);
        /*设置界面关闭模式,关闭一个页面就结束程序*/
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*设置界面的宽高*/
        this.setSize(700, 700);
        /*设置界面居中*/
        this.setLocationRelativeTo(null);
        /*取消默认的居中方式，取消后会按照左上角为原点，上边框为x轴，左边框为y轴定位添加组件*/
        this.setLayout(null);
        /*设置界面拖拽方式*/
        this.setResizable(false);
    }

    /**
     * @Description 初始化菜单
     * @param
     * @return void
     * @Author Cunhao Fan
     * @Date 2023/5/7 20:04
     */
    public void initJMenuBar() {
        /*创建整个菜单对象*/
        JMenuBar jMenuBar = new JMenuBar();
        /*创建菜单上的两个按钮，并初始化*/
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        /*创建选项下面的列表项*/
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");
        JMenuItem accountItem = new JMenuItem("公众号");
        /*将每个列表项加入对应的按钮下*/
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        aboutJMenu.add(accountItem);
        /*将按钮添加到菜单中*/
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        /*给整个界面设置菜单*/
        this.setJMenuBar(jMenuBar);
    }

    /**
     * @Description 初始化数据
     * @param
     * @return void
     * @Author Cunhao Fan
     * @Date 2023/5/7 23:04
     */
    private void initDate() {
        /*定义一个一维数组，表示图片的编号*/
        int [] arr = new int[16];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        /*打乱数组中的顺序 -> 打乱图片顺序*/
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            /*获取随机索引,范围为0-数组长度减1*/
            int index = random.nextInt(arr.length);
            /*将遍历到的数据和随机索引对应的数据进行交换*/
            int temp = arr [i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        /*给二维数组赋值*/
        for (int i = 0; i < arr.length; i++) {
            /*遍历一维数组将值赋给二维数组*/
            data[i / 4][i % 4] = arr[i];
        }
    }

    /**
     * @Description 初始化图片,先加载的图片在上方，后加载的图片在下方
     * @param
     * @return void
     * @Author Cunhao Fan
     * @Date 2023/5/7 22:53
     */
    private void initJLable() {
        /*外循环 -> 表示把内循环执行4次*/
        for (int i = 0; i < 4; i++) {
            /*内循环 -> 表示在一行添加4张图片*/
            for (int j = 0; j < 4; j++) {
                /*获取当前要加载的图片序号*/
                int index = data[i][j];
                /*创建图片对象*/
                ImageIcon icon = new ImageIcon("MyGame\\image\\"+index+".jpg");
                /*创建一个JLable管理容器对象*/
                JLabel jLabel = new JLabel(icon);
                /*指定图片位置*/
                jLabel.setBounds(105 * j +132, 105 * i + 108, 105, 105);
                /*给图片添加边 0:表示凸起来 1：表示凹下来*/
                jLabel.setBorder(new BevelBorder(1));
                /*把管理容器添加到页面中*/
                //this.add(jLabel);
                /*获取到隐藏的容器，把管理添加到页面中*/
                this.getContentPane().add(jLabel);
            }
        }
        /*添加背景图片*/
        JLabel bg = new JLabel(new ImageIcon("MyGame\\image\\bg.png"));
        bg.setBounds(75, 10, 539, 562);
        /*把背景图片添加到界面当中*/
        this.getContentPane().add(bg);
    }
}
