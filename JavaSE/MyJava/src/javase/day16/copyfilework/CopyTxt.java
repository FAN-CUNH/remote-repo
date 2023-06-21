package javase.day16.copyfilework;

import javautils.FileUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CopyTxt
 * @Description  利用封装的方法完成记事本的复制粘贴操作
 * @Author Cunhao Fan
 * @Date 2023/4/25 19:08
 * @Version 1.0
 */
public class CopyTxt {
    public static void main(String[] args) {
        /*实例化工具类*/
        FileUtils fileUtils = new FileUtils();
        /*先将文件中的内容读入内存并且存储到集合*/
        List<String> fileMess = new ArrayList<String>();
        fileMess.addAll(fileUtils.bufferedReaderFile("D:\\d.txt"));
        /*将获取到信息写出到目标文件*/
        fileUtils.bufferedWriterFile(fileMess,"D:\\d1.txt",false);
    }
}
