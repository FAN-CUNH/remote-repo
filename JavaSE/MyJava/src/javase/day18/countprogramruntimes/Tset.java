package javase.day18.countprogramruntimes;

import javautils.FileUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Tset
 * @Description 有一个用于记录程序运行次数的属性文件，运行次数保存在一个count属性中，当到达指定次数3次时，则提示:"程序使用次数已满，请续费"
 * @Author Cunhao Fan
 * @Date 2023/4/27 16:49
 * @Version 1.0
 */
public class Tset {
    public static void main(String[] args) throws Exception {
        /*判断属性文件是否存在，存在则和读入流建立连接，不存在则先创建，再建立连接*/
        FileUtils fileUtils = new FileUtils(); // 实例化文件工具类
        /*调用FileUtils中的createFile，当文件真实存在直接返回文件对象，文件不存在则创建文件后再返回文件对象*/
        File file = fileUtils.createFile("java\\src\\JavaSE\\day18\\countprogramruntimes\\Field.properties");
        /*调用FileUtils的*/
        /*定义一个属性信息集合用于存储从Field文件中读取的信息*/
        Map<String, String> filedMess = new HashMap<>();
        filedMess = fileUtils.propertiesRead(file.getAbsolutePath());
        /*获取filedMess集合中count的value*/
        int count; // 本程序计数器
        if (filedMess.size() == 0){
            count = 0;
        }else {
            count = Integer.parseInt(filedMess.get("count"));
        }
        /*根据CountField获取class对象,并实例化对象*/
        Class c = CountField.class;
        Object o = c.newInstance();
        /*根据获取到的class对象获取count属性*/
        Field field = c.getDeclaredField("count");
        field.setAccessible(true); // 暴力反射
        count++; // 每运行一次 计数器+1
        if (count <= 3) {
            field.set(o, count); // 将属性赋值
            filedMess.put(field.getName(), count + ""); // 存入fieldMess
            fileUtils.propertiesWrite(filedMess, file.getAbsolutePath()); // 写出到properties文件
            System.out.println("本程序剩余使用次数："+(3 - count));
        }else {
            System.out.println("程序使用次数已满，请续费！");
        }
    }
}
