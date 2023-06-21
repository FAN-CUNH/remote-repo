package javase.day21.udp_work;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName UDPSender
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/8 17:43
 * @Version 1.0
 */
public class UDPSender {
    /*成员方法*/

    public boolean sendMess(String messForSend) throws Exception {
        /*创建发送端的发送对象 -> 用来发送或者接收数据包，端口号为8000*/
        DatagramSocket datagramSocket = new DatagramSocket(8000);
        /*实现连续发送效果*/

        /*标记 假设发送端不停发送*/
        boolean isExit = false;
        /*当接收到的信息为exit，则停止发送*/
        if (messForSend.equals("exit")) {
            isExit = true;
        }
        /*持续发送*/
        if (!isExit) {
            /*创建数据包对象 参数 -> 发送的信息， 发送的信息长度， ip地址， 接收端口号*/
            DatagramPacket datagramPacket = new DatagramPacket(messForSend.getBytes(), messForSend.getBytes().length, InetAddress.getLocalHost(), 8081);
            /*利用套接字发送数据包*/
            datagramSocket.send(datagramPacket);
            System.out.println(messForSend);
        }
        /*通知接收端，发送端已停止发送，让接收端停止接收*/
        else {
            DatagramPacket datagramPacket = new DatagramPacket("exit".getBytes(), messForSend.getBytes().length, InetAddress.getLocalHost(), 8081);
            datagramSocket.send(datagramPacket);
        }
        /*关闭发送端对象，并释放接口*/
        datagramSocket.close();
        return isExit;
    }
}
