package javase.day21.nio_work;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NIO
 * @Description 使用NIO完成删除文件中的所有数字
 *              使用NIO完成文件的复制粘贴
 * @Author Cunhao Fan
 * @Date 2023/5/8 22:14
 * @Version 1.0
 */
public class NIO {

    public static void main(String[] args) throws Exception{
        /*创建缓冲区,初始化容量1024字节*/
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        /*文件输入流*/
        FileInputStream fileInputStream = new FileInputStream("D:\\IDEA\\IDEA Project\\Java\\src\\JavaSE\\day21\\nio_work\\A.txt");
        /*获取文件套接字管道*/
        FileChannel fileChannel = fileInputStream.getChannel();
        /*将文件内容读取到缓冲区*/
        fileChannel.read(byteBuffer);
        /*字符串接收*/
        String mess = new String(byteBuffer.array());
        /*过滤数字*/
        mess = mess.replaceAll("\\d+", "");
        System.out.println(mess);

        /*创建文件输出流*/
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\IDEA\\IDEA Project\\Java\\src\\JavaSE\\day21\\nio_work\\A.txt");
        /*获取管道*/
        FileChannel fileChannel1 = fileOutputStream.getChannel();
        /*创建缓冲区,初始化容量1024字节*/
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
        /*将文件内容放到缓冲区*/
        byteBuffer1.put(mess.getBytes());
        /*反转*/
        byteBuffer1.flip();
        /*写入文件*/
        fileChannel1.write(byteBuffer1);
    }
}
