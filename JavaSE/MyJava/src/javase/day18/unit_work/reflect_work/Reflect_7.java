package javase.day18.unit_work.reflect_work;

import javautils.FileUtils;

import java.util.Map;

/**
 * @ClassName Reflect_7
 * @Description (1)写一个Properties格式的配置文件，配置类的完整名称。
 *              (2)写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类。
 *              (3)用反射的方式运行run方法。
 * @Author Cunhao Fan
 * @Date 2023/5/3 17:28
 * @Version 1.0
 */
public class Reflect_7 {
    public static void main(String[] args) throws Exception{
        FileUtils fileUtils = new FileUtils();
        Map<String, String> map = fileUtils.propertiesRead("java\\src\\JavaSE\\day18\\unit_work\\reflect_work\\student_class.properties");
        System.out.println(map);
        System.out.println(map.get("Student_path").replaceAll("\\\\\\\\", "."));
        String Student_path = map.get("Student_path").replaceAll("\\\\\\\\", ".");
        Class c = Class.forName(Student_path);
        Object o = c.newInstance();
        ((Student)o).run();
    }
}
