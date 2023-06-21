package javase.day21.tcp_work;

import java.util.Scanner;

/**
 * @ClassName TCPSendFileTest
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/8 19:06
 * @Version 1.0
 */
public class TCPSendFileTest {
    public static void main(String[] args) throws Exception {
        /*实例化发送端*/
        TCPSendFile tcpSendFile = new TCPSendFile();
        /*实例化键盘录入对象，获取键盘录入信息*/
        Scanner scanner = new Scanner(System.in);
        /*输入需要发送的文件路径*/
        System.out.println("请输入需要上传路径");
        String filePath = scanner.nextLine();
        tcpSendFile.sendMessToReceiver(filePath);

        String fileMess = tcpSendFile.readFileMess(filePath);
        tcpSendFile.sendMessToReceiver(fileMess);
    }
}
