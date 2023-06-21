package javase.day14.work.file;

import java.io.*;
import java.util.ArrayList;

/**
 * @ClassName FileUtil
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/24 9:46
 * @Version 1.0
 */
public class FileUtil {
    /*创建文件*/
    public File createFile(String filePath) {
        /*实例化文件对象*/
        File file = new File(filePath);
        /*判断文件是否存在[exists()表示文件或者目录是否存在]，存在则可以进行操作，否则，要先创建文件[使用mkdirs()创建多级父目录，使用createNewFile()创建标准文件]*/
        if (file.exists()) {
            System.out.println("该文件存在！");
        } else {
            System.out.println("该文件不存在！现在进行创建文件操作！");
            /*使用getParentFile()获取父级目录,并判断是否有父级目录*/
            if (file.getParentFile() != null) {
                /*有父级目录，则根据获取的父级目录创建真实父级目录*/
                file.getParentFile().mkdirs();
            }
            /*创建标准文件,并抛出可能出现的异常*/
            try {
                file.createNewFile();
                System.out.println("创建成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /*遍历文件*/
    public void listFiles(String filePath, ArrayList<String> allFilePath) {
        /*根据接收的文件路径实例化文件对象*/
        File file = new File(filePath);// 此时文件一定已经真实存在，不然无法进行遍历
        /*liftFile()获取该文件下的所有文件返回值是一个数组,并判断返回的数组地址是否存在，数组存在则确定数组中是否有子文件即长度是否为0*/
        if (file.listFiles() != null) { //表示该文件是可以访问的文件，不能访问的文件或者被保护的文件listFiles()的返回值是为Null
            if (file.listFiles().length == 0) {//表示该文件下没有子文件，则将接收到的文件目录路径存入集合
                allFilePath.add(filePath);
            } else { // 存在子文件或子目录 遍历每一个文件或目录
                for (File everyFile : file.listFiles()
                ) {
                    if (everyFile.isFile()) { // 是标准文件，则将文件的绝对路径存入集合
                        allFilePath.add(everyFile.getAbsolutePath());
                    } else { // 是目录，则重新调用该方法 参数分别为该子目录的绝对路径和接收到的allFilePath集合
                        listFiles(everyFile.getAbsolutePath(), allFilePath);
                    }
                }
            }
        } else { // 不可访问（被隐藏或是被保护） 将此文件的绝对路径存入集合
            allFilePath.add(filePath);
        }
    }

    /*删除文件*/
    public void deleteFiles(String filePath) {
        /*根据接收的文件路径，实例化文件对象*/
        File file = new File(filePath);
        /*获取该文件路径下的所有文件*/
        File[] allFilePath = file.listFiles();
        if(file.isFile()){
            file.delete();
        }
        /*判断文件路径对应的文件是否可以访问，即File[]数值的引用地址是否存在*/
        if (allFilePath == null) { // 该文件不可访问(被隐藏或者被保护)
            System.out.println("文件无法访问，不可删除！");
        }
        else { // 文件可以访问
            /*判断当前文件路径下的子文件或者子目录个数*/
            if (allFilePath.length != 0) { // 文件不是空
                /*遍历每一个文件或者目录*/
                for (File everyFile : allFilePath
                ) {
                    if (everyFile.isFile()) { // 是标准文件，执行删除
                        everyFile.delete();
                    } else { // 是目录，重新调用deleteFiles()方法,参数为该子目录的绝对路径
                        this.deleteFiles(everyFile.getAbsolutePath());
                    }
                }
                /*删除完该路径对应文件下的所有子文件和子目录，执行删除该文件操作*/
                file.delete();
            } else { // 该文件路径对应的文件是空文件，执行删除本文件操作
                file.delete();
            }
        }
    }

    /*读取文件*/
    public String readFile(String filePath) {
        /*根据接收的文件路径实例化文件对象*/
        File file = new File(filePath);
        /*读取文件，将文件的内容利用文件输入流写入内存*/
        InputStream inputStream = null;
        byte[] b = null;
        try {
            /*将文件和输入流建立连接*/
            inputStream = new FileInputStream(file);
            /*创建一个字节型数组，用于存储从文件中读取的字符，数组长度利用输入流的available()得出*/
            b = new byte[inputStream.available()];
            /*使用输入流的read(byte[] b)方法一次性读取存入b数组*/
            inputStream.read(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*关闭输入流*/
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new String(b);
    }

    /*写入文件*/
    public void writeFile(String content, String targetFile) {
        /*根据接收内容和目标文件路径实例化文件对象*/
        File file = new File(targetFile);
        /*将文件和文件字节输入流建立联系*/
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            /*将接收到的字符串转化成字节型数组*/
            outputStream.write(content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
