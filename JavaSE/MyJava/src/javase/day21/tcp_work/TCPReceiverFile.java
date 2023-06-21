package javase.day21.tcp_work;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCPReceiverFile
 * @Description 服务器端接收文件
 * @Author Cunhao Fan
 * @Date 2023/5/8 19:29
 * @Version 1.0
 */
public class TCPReceiverFile {
    /*声明服务器端*/
    ServerSocket serverSocket = null;
    /*声明文件路径*/
    String filePath;

    public TCPReceiverFile() {
        /*实例化的同时初始化服务器端对象指定监控的端口号*/
        try {
            this.serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*成员方法*/

    /**
     * @param
     * @return void
     * @Description 从端口获取到发送端发出的信息
     * @Author Cunhao Fan
     * @Date 2023/5/8 19:37
     */
    public void getMessFromSender() throws Exception {
       while (true) {
           /*服务器端通过阻塞式等待连接客户端*/
           Socket socket = serverSocket.accept();
           /*连接成功后通过获取由转换流得到的字符缓冲输入流*/
           InputStream inputStreamReader =socket.getInputStream();
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

           String mess = bufferedReader.readLine();
           System.out.println(mess);
           if (filePath == null) {
               filePath = mess;
           }
           else {
               writeFile(mess);
           }
       }

    }

    public void writeFile(String mess) throws Exception {
        if (mess != null) {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\IDEA\\IDEA Project\\Java\\src\\JavaSE\\day21\\tcp_work\\a-copy.txt"));
            bufferedWriter.write(mess);
            bufferedWriter.flush();
        }
    }
}
