package javase.day21.test;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @ClassName TCPReceiver
 * @Description TCP服务器
 * @Author Cunhao Fan
 * @Date 2023/5/8 12:15
 * @Version 1.0
 */
public class TCPReceiver {
    public static void main(String[] args) throws Exception{
        /*实例化服务器Socket对象 -> 表示一个服务器程序*/
        ServerSocket myServerSocket = new ServerSocket(8080);
        /*获取Socket对象*/
        Socket socket = myServerSocket.accept();
        /*通过Socket类对象获取输入流*/
        InputStream inputStream = socket.getInputStream();
        /*创建byte数组用于存储接收到的数据*/
        byte[] acceptMess = new byte[1024];
        /*定义一个int类型len变量 -> 表示当前读取到的有效数据长度*/
        int len = 0;
        /*定义一个StringBuffer类型的字符串缓冲区 -> 存储读取到的数据*/
        StringBuffer stringBuffer = new StringBuffer("");
        /*int = inputStream.read(byte[] b) -> 表示从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中。返回int -> 每次读取的有效字节个数*/
        len = inputStream.read(acceptMess);
        stringBuffer.append(new String(acceptMess, 0, len));

        /*输出发送端发送过来的数据信息*/
        /*for (byte everyByte: acceptMess
             ) {
            if (everyByte != 0) {
                System.out.print((char)everyByte);

            }
        }*/

        System.out.println("发送端发送的数据信息："+stringBuffer.toString());

        /*关闭ServerSocket*/
        myServerSocket.close();
    }
}
