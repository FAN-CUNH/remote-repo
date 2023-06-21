package javase.day21.tcp_work;

/**
 * @ClassName TCPReceiverFileTest
 * @Description 接收方收到数据后将内容写入服务器端的新文件
 * @Author Cunhao Fan
 * @Date 2023/5/8 19:29
 * @Version 1.0
 */
public class TCPReceiverFileTest {
    public static void main(String[] args) throws Exception {
        TCPReceiverFile tcpReceiverFile = new TCPReceiverFile();
        tcpReceiverFile.getMessFromSender();
    }
}
