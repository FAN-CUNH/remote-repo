package javautils;

import javase.day18.student_manage_system.Student;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @ClassName FileUtils
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/25 19:01
 * @Version 1.0
 */
public class FileUtils {
    /*创建文件*/
    public File createFile(String filePath) {
        /*实例化文件对象*/
        File file = new File(filePath);
        /*判断文件是否存在[exists()表示文件或者目录是否存在]，存在则可以进行操作，否则，要先创建文件[使用mkdirs()创建多级父目录，使用createNewFile()创建标准文件]*/
        if (file.exists()) {
            //System.out.println("该文件存在！");
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
        if (file.isFile()) {
            file.delete();
        }
        /*判断文件路径对应的文件是否可以访问，即File[]数值的引用地址是否存在*/
        if (allFilePath == null) { // 该文件不可访问(被隐藏或者被保护)
            System.out.println("文件无法访问，不可删除！");
        } else { // 文件可以访问
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
                str = sb.toString().replaceAll("\\d+", "");
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
    public List<String> bufferedReaderFile(String filePath) {
        /*实例化一个信息集合用于存储读入的信息*/
        List<String> strOfMess = new ArrayList<>();
        /*实例化操作对象*/
        /*如果操作对象已存在则直接将其与字符读入流建立联系然后再与字符读入缓冲流建立联系，否早先创建操作对象再建立联系*/
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)))) {
            /*声明一个line字符变量，用于存储每次读取到的一行信息*/
            String line = null;
            while ((line = bufferedReader.readLine()) != null) { // 如果此次读取到的信息为空，则表示所有信息已读取完毕
                strOfMess.add(line); // 将信息存入集合
            }
        } catch (Exception e) {
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
    public void bufferedWriterFile(List<String> strOfMess, String targetFile, boolean append) {
        /*实例化操作对象*/
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(targetFile), append))) {
            /*将集合中信息写出到文件*/
            for (String everyMess : strOfMess
            ) {
                bufferedWriter.write(everyMess);
                bufferedWriter.newLine(); // 没写完一部分信息执行一次换行
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void bufferedWriterFile2(List<Student> strOfMess, String targetFile, boolean append) {
        /*实例化操作对象*/
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(targetFile), append))) {
            /*将集合中信息写出到文件*/
            for (Student everyMess : strOfMess
            ) {
                bufferedWriter.write(everyMess.toString());
                bufferedWriter.newLine(); // 没写完一部分信息执行一次换行
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 将properties文件中的内容读入内存
     * @Param: [propertiesFilePath：properties文件的绝对路径]
     * @Return: void
     * @Author: Cunhao Fan
     * @Time: 13:46
     */
    public Map<String, String> propertiesRead(String propertiesFilePath) {
        /*实例化properties对象*/
        Properties properties = new Properties();
        Map<String, String> mapOfProperties = new HashMap<>();
        /*建立文件和读入流的联系*/
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(propertiesFilePath))) {
            properties.load(bufferedReader);
            /*获取properties文件中所有的key*/
            Set<String> allKey = properties.stringPropertyNames();
            /*根据获取的所有的key得到所有的value,并将键值对关系存入Map中*/
            for (String everykey: allKey
                 ) {
                String value = properties.getProperty(everykey);
                /*指定编码格式 String(byte[] bytes, Charset charset) 通过使用指定的charset解码指定的字节数组构造一个新的String*/
                /*byte[] = getBytes(String charsetName) 使用指定的charset编码一个字节序列，并将结果存储到一个新的字节序列。  */
                value = new String(value.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
                mapOfProperties.put(everykey, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapOfProperties;
    }
    /**
    * @Description: 封装将集合信息写入properties文件的方法
    * @Param: [map：需要写出文件的关系信息结合, targetPropertiesFilePath：写出文件的路径]
    * @Return: void
    * @Author: Cunhao Fan
    * @Time: 14:04
    */
    public void propertiesWrite(Map<String, String> map, String targetPropertiesFilePath) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetPropertiesFilePath))) {
            Properties properties = new Properties();
            /*将集合中的信息全部放入properties文件*/
            properties.putAll(map);
            properties.store(bufferedWriter, "用户信息");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
