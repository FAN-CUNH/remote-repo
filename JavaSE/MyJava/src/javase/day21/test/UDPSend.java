package javase.day21.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName UDPSend
 * @Description 发送方
 * @Author Cunhao Fan
 * @Date 2023/5/8 9:41
 * @Version 1.0
 */
public class UDPSend {
    public static void main(String[] args) throws Exception{
        //1 创建数据包
        String content = "hello";
        byte[] bytes = content.getBytes();
        InetAddress inetAddress = InetAddress.getByName("192.168.24.33");//获取本机ip对象信息
        int port = 8888; //1024-65535
        DatagramPacket datagramPacket = new  DatagramPacket(bytes, bytes.length, inetAddress, port);
        //2 套接字用来发送或者接收数据包
        DatagramSocket datagramSocket = new DatagramSocket(6666);//6666是发送方出去数据包的端口
        //3 发送数据包:send(数据包对象)
        datagramSocket.send(datagramPacket);
        //4 关闭套接字
        datagramSocket.close();


    }
}
