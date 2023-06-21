package javase.day21.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @ClassName UDPReceiver
 * @Description 接收方
 * @Author Cunhao Fan
 * @Date 2023/5/8 9:38
 * @Version 1.0
 */
public class UDPReceiver {
    public static void main(String[] args) throws Exception {
        //8888:是接收数据包的端口
        //1 定义数据包接收8888端口的数据
        byte[] bytes = new  byte[1024];//bytes用来接收发送方发送过来的数据
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
        //2 使用套接字进行接收数据
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //3 接收数据
        datagramSocket.receive(datagramPacket);

        int len = datagramPacket.getLength();//接收到的真实数据长度
        System.out.println("真实接收到的数据长度："+len);
        //获取发送方的数据
        String content = new String(bytes,0,len);
        System.out.println("发送发发送过来的数据："+content);


        //4 关闭套接字
        datagramSocket.close();
    }
}
