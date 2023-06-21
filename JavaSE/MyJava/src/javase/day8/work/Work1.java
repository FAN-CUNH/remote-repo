package javase.day8.work;

/**
 * @ClassName Work1
 * @Description 通过try-catch和方法体外2种方式捕获异常
 * @Author Cunhao Fan
 * @Date 2023/4/15 11:31
 * @Version 1.0
 */
import java.io.*;

public class Work1 {
    public static void main(String[] args) throws IOException {
            String filePath = "E:"+ File.separator+"HelloWorld.java";
        /*try {
            //可能发生异常的语句
            InputStream inputStream = new FileInputStream(filePath);
            inputStream.read();//遇到异常，将异常对象交给exception对象
            System.out.println("我没有发生异常");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("我发生异常");
        }*/

        InputStream inputStream = new FileInputStream(filePath);
        inputStream.read();//遇到异常，将异常对象交给exception对象
    }
}
