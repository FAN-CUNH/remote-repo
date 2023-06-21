package javase.day21.udp_work;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @ClassName UDPReceiver
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/8 18:35
 * @Version 1.0
 */
public class UDPReceiver {
    public void receiveMess() throws Exception {
        /*创建接收端的接收对象*/
        DatagramSocket datagramSocket = new DatagramSocket(8081);
        while (true) {
            /*定义一个byte类型数组，用于存储每次接收到的信息*/
            byte[] messOfReceive = new byte[1024];
            /*创建接收端数据包 参数： 接收的信息， 接收的信息长度*/
            DatagramPacket datagramPacket = new DatagramPacket(messOfReceive, messOfReceive.length);
            /*接收信息*/
            datagramSocket.receive(datagramPacket);
            /*定义一个int类型的变量len，表示byte数组中的有效信息长度*/
            int len = datagramPacket.getLength();
            /*读取接收到的信息*/
            String mess = new String(messOfReceive, 0, len);
            /*判断接收到信息是否是有效信息，exit信息不需要打印*/
            if (mess.equals("exit")) {
                break;
            }
            System.out.println(mess);
        }
        /*关闭接收端，并释放接口*/
        datagramSocket.close();
    }
}
