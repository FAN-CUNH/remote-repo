package javase.day21.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCPFileReceiver
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/8 14:17
 * @Version 1.0
 */
public class TCPFileReceiver {
    /*声明ServerSocket类对象*/
    ServerSocket serverSocket = null;

    /*在实例化本类对象的同时初始化本类对象*/
    public TCPFileReceiver() {
        try {
            this.serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void printSendFileMessAndWrite() throws IOException {
        /*获取发送方发送的文件信息*/

        /*通过ServerSocket对象获取Socket*/
        Socket socket = serverSocket.accept();
        /*通过Socket获取输入流*/
        InputStream inputStream = socket.getInputStream();
        /*通过inputStream获取信息，并存入byte[]中*/
        byte[] sendFileMess = new byte[1024];
        /*获取到sendFileMess数组中的有效数据长度*/
        int len = inputStream.read(sendFileMess);
        /*获取有效长度的内容*/
        String receiverFileMess = new String(sendFileMess, 0, len);
        System.out.println(receiverFileMess);
        /*创建字符缓冲写出流，将写出文件路径传入*/
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\IDEA\\IDEA Project\\Java\\src\\JavaSE\\day21\\test\\b.txt"));
        bufferedWriter.write(receiverFileMess);
        /*清空缓冲区，将信息写入文件*/
        bufferedWriter.flush();
    }

    public static void main(String[] args) throws IOException {
        TCPFileReceiver tcpFileReceiver = new TCPFileReceiver();
        tcpFileReceiver.printSendFileMessAndWrite();
    }
}
