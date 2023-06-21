package javase.day21.tcp_work;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ClassName TCPSendFile
 * @Description 本地读文件然后将文件内容发送到接收方
 * @Author Cunhao Fan
 * @Date 2023/5/8 19:05
 * @Version 1.0
 */
public class TCPSendFile {
    /*成员方法*/
    /**
     * @Description 读取文件信息
     * @param filePath 读取文件的路径
     * @return String 返回所读取到的信息
     * @Author Cunhao Fan
     * @Date 2023/5/8 19:08
     */
    public String readFileMess(String filePath) throws Exception{
        File file = new File(filePath);
        if (file.isFile()) {
            /*读取文件信息*/
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String fileMess = bufferedReader.readLine();
            System.out.println(fileMess);
            bufferedReader.close();
            return fileMess;
        }
        else {
            return null;
        }
    }

    /**
     * @Description 将从文件读取到的信息发送到接收端
     * @param mess 要发送的信息
     * @return void
     * @Author Cunhao Fan
     * @Date 2023/5/8 19:10
     */
    public void sendMessToReceiver(String mess) throws Exception {
        /*创建客户端对象 参数：ip地址， 端口号*/
        Socket socket = new Socket(InetAddress.getLocalHost(), 8080);
        /*通过客户端对象获取字节输出流*/
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        if (mess != null) {
            /*通过输出流将信息发送到服务器端*/
            bufferedWriter.write(mess);
        }
        /*关闭流*/
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
