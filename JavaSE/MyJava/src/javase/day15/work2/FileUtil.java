package javase.day15.work2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FileUtil
 * @Description 封装字符流，字符缓冲流
 * @Author Cunhao Fan
 * @Date 2023/4/24 18:19
 * @Version 1.0
 */
public class FileUtil {
    /*读入文件信息*/
    public String readerFile(String filePath) {
        /*根据接收到的文件路径实例化文件对象*/
        //File file = new File(filePath);
        /*实例化字符串缓冲区并初始化为空字符串，用于存储读取到的字符信息*/
        StringBuffer sb = new StringBuffer("");
        String str = "";
        /*实例化字符输入流*/
        try (Reader reader = new FileReader(filePath)) {
            /*使用reader.read(char[] c)一次性读入所有字符*/
            char[] c = new char[1024];
            int len; // 用于保存read()的返回值，表示读取字符的个数
            while ((len = reader.read(c)) != -1) { // read()的返回值为-1时表示该文件的字符已经全部读取完毕
                /*将每次读取到的信息追加到字符串缓冲区*/
                sb.append(String.valueOf(c, 0, len));
                System.out.println(sb.toString());
                /*将字符串中的数字删除*/
                str = sb.toString().replaceAll("\\d+","");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /*写出文件*/
    public void writerFile(String content, String targetFile, boolean append) {
        /*根据接收的目标文件绝对路径，实例化目标文件并将其和字符输出流建立联系*/
        try (Writer waiter = new FileWriter(targetFile, append)) {
            waiter.write(content);// waiter.append(content); 此处两者作用相同
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    * @Description: 封装字符缓冲读入流
    * @Param: [filePath: 要读入的文件地址]
    * @Return: java.util.List<java.lang.String> :文件中读入信息所储存的集合
    * @Author: Cunhao Fan
    * @Time: 16:41
    */
    /*缓冲流 字符读入流*/
    public List<String> bufferedReaderFile(String filePath) {
        /*实例化一个信息集合用于存储读入的信息*/
        List<String> strOfMess = new ArrayList<>();
        /*实例化操作对象*/
        /*如果操作对象已存在则直接将其与字符读入流建立联系然后再与字符读入缓冲流建立联系，否早先创建操作对象再建立联系*/
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new javase.day14.work.file.FileUtil().createFile(filePath)))) {
            /*声明一个line字符变量，用于存储每次读取到的一行信息*/
            String line = null;
            while ((line = bufferedReader.readLine()) != null) { // 如果此次读取到的信息为空，则表示所有信息已读取完毕
                strOfMess.add(line); // 将信息存入集合
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        /*将读取到的信息返回*/
        return strOfMess;
    }

    /**
    * @Description: 封装字符缓冲流的写出操作
    * @Param: [strOfMess:要写出的信息, targetFile:写出的目标文件地址]
    * @Return: void
    * @Author: Cunhao Fan
    * @Time: 16:35
    */
    public void BufferedWriterFile(List<String> strOfMess, String targetFile) {
        /*实例化操作对象*/
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(targetFile)))) {
            /*将集合中信息写出到文件*/
            for (String everyMess:strOfMess
                 ) {
                bufferedWriter.write(everyMess);
                bufferedWriter.newLine(); // 没写完一部分信息执行一次换行
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
