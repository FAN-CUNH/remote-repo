package javase.day21.test;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ClassName TCPSend
 * @Description TCP发送方
 * @Author Cunhao Fan
 * @Date 2023/5/8 11:41
 * @Version 1.0
 */
public class TCPSend {
    public static void main(String[] args) throws Exception{
        /*获取本机ip地址*/
        InetAddress myInetAddress = InetAddress.getLocalHost();
        /*实例化客户端Socket(String host -> ip地址, int port -> 端口号)*/
        Socket socket = new Socket(myInetAddress,8080);
        /*获取输出流对象*/
        OutputStream outputStream = socket.getOutputStream();
        String content = "HelloWord";
        /* write(参数：字节数组)*/
        outputStream.write(content.getBytes());

        /*关闭socket*/
        socket.close();
    }
}
