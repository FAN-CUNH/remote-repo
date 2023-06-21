package javase.day22.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @ClassName MySwing
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/8 16:30
 * @Version 1.0
 */
class MyJFrame extends JFrame {
    public MyJFrame() throws HeadlessException {

        /*初始化界面*/
        initJFrame();

        /*初始化菜单*/
        initJMenuBar();

        /*设置界面可见*/
        this.setVisible(true);
    }

    private void initJMenuBar() {
        /*创建一个菜单栏*/
        JMenuBar jMenuBar = new JMenuBar();
        JMenu.setDefaultLocale(null);
        /*创建4个菜单按钮*/
        JMenu add = new JMenu("加");
        JMenu sub = new JMenu("减");
        JMenu mul = new JMenu("乘");
        JMenu div = new JMenu("除");
        /*将按钮添加到菜单栏*/
        jMenuBar.add(add);
        jMenuBar.add(sub);
        jMenuBar.add(mul);
        jMenuBar.add(div);
        /*设置界面菜单栏*/
        this.setJMenuBar(jMenuBar);
        /*创建一个长度为16的字符串数组*/
        String[] arr = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", ".", "=", "/"};
        /*创建一个二维数组*/
        String[][] jButtonText = new String[4][4];
        for (int i = 0; i < arr.length; i++) {
            jButtonText[i /4][i % 4] = arr[i];
        }
        ArrayList<String> arrayList = new ArrayList<>();
        /*创建2个文本框用于输出结果*/
        JTextField jTextField = new JFormattedTextField();
        JTextField jTextField2 = new JFormattedTextField();

        jTextField.setBounds(70, 20, 75, 30);
        jTextField2.setBounds(150, 20, 75, 30);
        this.getContentPane().add(jTextField);
        this.getContentPane().add(jTextField2);
        StringBuffer stringBuffer = new StringBuffer("");
        /*设置归零按钮*/
        JButton jButton0 = new JButton("归零");
        jButton0.setBounds(40, 200, 200, 30);
        this.getContentPane().add(jButton0);
        /*设置16个按钮*/
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton jButton = new JButton(jButtonText[i][j]);
                jButton.setBounds(j * 50+40, i * 30+80, 50, 30);
                this.getContentPane().add(jButton);
                jButton.addActionListener(e -> {
                        stringBuffer.append(jButton.getText());
                        arrayList.add(jButton.getText());
                    if (jButton.getText().equals("=")) {
                        stringBuffer.append("=");
                        System.out.println(arrayList);
                        String s = String.join("", arrayList);
                        s = s.substring(0, s.indexOf("="));
                        System.out.println(s);
                        ScriptEngineManager m = new ScriptEngineManager();
                        ScriptEngine engine = m.getEngineByName("javascript");
                        try {
                            System.out.println(engine.eval(s));
                        } catch (ScriptException scriptException) {
                            scriptException.printStackTrace();
                        }
                        try {
                            jTextField2.setText(engine.eval(s)+"");
                        } catch (ScriptException scriptException) {
                            scriptException.printStackTrace();
                        }
                    } else {
                        jTextField.setText(stringBuffer.toString());
                    }
                });
            }
        }
        jButton0.addActionListener(e -> {
            stringBuffer.delete(0, stringBuffer.length());
            jTextField.setText(stringBuffer.toString());
            jTextField2.setText(stringBuffer.toString());
            arrayList.clear();
        });
    }

    public void initJFrame() {
        /*设置界面的名称*/
        this.setTitle("我的计算机 v1.0");
        /*设置界面的宽高*/
        this.setSize(300, 400);
        /*设置界面的居中方式*/
        this.setLocationRelativeTo(null);
        /*设置不可拖拽*/
        this.setResizable(false);
        /*设置界面的关闭模式*/
        this.setDefaultCloseOperation(3);
        /*设置界面置顶*/
        this.setAlwaysOnTop(true);
        /*设置界面的布局*/
        this.setLayout(null);
    }
}
public class MySwing {
    public static void main(String[] args) {
        new MyJFrame();
    }
}
