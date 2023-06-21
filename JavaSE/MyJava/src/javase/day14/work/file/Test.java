package javase.day14.work.file;

import java.util.ArrayList;

/**
 * @ClassName Test
 * @Description 测试FileUtils类中的方法
 * @Author Cunhao Fan
 * @Date 2023/4/24 11:05
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();
        fileUtil.createFile("D:\\A\\B\\c.txt");
        ArrayList<String> allFilePath = new ArrayList<String>();
        fileUtil.listFiles("D:\\A",allFilePath);
        allFilePath.stream().forEach(System.out::println);
        String content = fileUtil.readFile("D:\\A\\B\\c.txt");
        System.out.println(content);
        fileUtil.writeFile(content,"D:\\A\\B\\c2.txt");
        fileUtil.deleteFiles("D:\\A");
    }
}
