package javase.day14.work.work5;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName File
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/23 21:15
 * @Version 1.0
 */
public class FileWork {
    public static void main(String[] args) throws IOException {
    /*1 完成创建D://A//B//c.txt文件；完成创建D://A//D文件夹*/
        //String filePath = "D:"+ File.separator+"A"+File.separator+"B"+File.separator+"c.txt";
        /*先创建父目录*/
        File file = new File("D:\\A\\B");
        file.mkdirs();
        /*再创建标准文件*/
        File file1 = new File("D:\\A\\B\\c.txt");
        file1.createNewFile();
        System.out.println(file1);
    /*2 将D盘下某个文件夹中的文件夹的个数打印出来*/
    /*3 将D盘下的某个文件夹中所有记事本删除*/
        File file2 = new File("D:\\A");
        File[] allFile = file2.listFiles();
        int countFiles = 0;// 用于存储文件个数
        if (allFile != null) { // 文件可以被访问
            if (allFile.length == 0) { // 空文件
                System.out.println("该文件是空文件夹！"+countFiles);
            }else {
                for (File everyFile:allFile
                     ) {
                    if (everyFile.isFile()) { // 是标准文件
                        /*标准文件不用计数*/
                        /*删除记事本文件*/
                        if (everyFile.getAbsolutePath().endsWith(".txt")) {
                            everyFile.delete();
                        }
                    }else { // 是文件夹
                        countFiles++;
                    }
                }
                System.out.println("该文件夹中的文件夹个数："+countFiles);
            }
        }
    }
}
