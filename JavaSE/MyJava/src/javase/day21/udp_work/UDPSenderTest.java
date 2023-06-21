package javase.day21.udp_work;

import java.util.Scanner;

/**
 * @ClassName UDPSenderTest
 * @Description 通过UDP实现键盘录入循环发送和接收数据
 *              如果对方退出可以通过特殊数据包提示接收方，让接收方不再接收数据
 * @Author Cunhao Fan
 * @Date 2023/5/8 18:10
 * @Version 1.0
 */
public class UDPSenderTest {
    public static void main(String[] args) throws Exception {
        /*创建键盘录入对象，并接收键盘录入信息*/
        Scanner scanner = new Scanner(System.in);
        /*实例化发送端*/
        UDPSender udpSender = new UDPSender();
        /*假设不停发送*/
        boolean isExit = false;
        while (!isExit) {
            System.out.println("请输入发送端需要发送的信息：");
            String mess = scanner.next();
            /*调用发送信息方法*/
            isExit = udpSender.sendMess(mess);
        }
    }
}
