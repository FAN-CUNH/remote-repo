package javase.day16.propertieswork;

import javase.day16.studentmanage.Student;
import javautils.FileUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PropertiesWork
 * @Description 将某个学生对象的属性和属性值关系存入student.properties文件
 * @Author Cunhao Fan
 * @Date 2023/4/26 14:05
 * @Version 1.0
 */
public class PropertiesWork {
    public static void main(String[] args) {
        Student student = new Student("001", "zhangsan");
        Map<String, String> stuMess = new HashMap<>();
        stuMess.put("stuNo", student.getStuNo());
        stuMess.put("stuName", student.getStuName());
        FileUtils fileUtils = new FileUtils();
        fileUtils.propertiesWrite(stuMess, "D:\\students.properties");
        Map<String, String> map = fileUtils.propertiesRead("D:\\students.properties");
        System.out.println(map);
    }
}
