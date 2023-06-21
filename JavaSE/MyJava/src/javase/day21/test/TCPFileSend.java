package javase.day21.test;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName TCPFileSend
 * @Description 通过TCP读取本地信息，将数据发送给接收方
 * @Author Cunhao Fan
 * @Date 2023/5/8 13:25
 * @Version 1.0
 */
public class TCPFileSend {
    public String readFileMess(String filePath) throws Exception {
        /*先将文件中的信息读取到byte数组*/
        byte[] fileMess = new byte[1024];
        /*读文件*/
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        /*定义一个String类型everyLineMess -> 存储读取到的每行信息*/
        String everyLineMess = null;
        while ((everyLineMess = bufferedReader.readLine()) != null) {
            /*将每行信息存入byte数组*/
            fileMess = everyLineMess.getBytes();
        }
        bufferedReader.close();
        return new String(fileMess, StandardCharsets.UTF_8);
    }

    public void sendFileMessToReceiver(String mess, String FilePath) throws Exception {
        /*创建Socket对象*/
        Socket socket = new Socket(InetAddress.getLocalHost(), 8080);
        /*获取输出流*/
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(mess.getBytes());

        /*关闭Socket*/
        socket.close();
    }
    public static void main(String[] args) throws Exception{
        String filePath = "D:\\IDEA\\IDEA Project\\Java\\src\\JavaSE\\day21\\test\\a.txt";
        String targetFilePath = "D:\\IDEA\\IDEA Project\\Java\\src\\JavaSE\\day21\\test\\b.txt";
        TCPFileSend tcpFileSend = new TCPFileSend();
        String fileMess = tcpFileSend.readFileMess(filePath);
        System.out.println(fileMess);
        tcpFileSend.sendFileMessToReceiver(fileMess, targetFilePath);
    }
}
