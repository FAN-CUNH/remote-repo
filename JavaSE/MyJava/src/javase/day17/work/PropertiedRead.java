package javase.day17.work;

import javautils.FileUtils;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @ClassName PropertiedWork
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/26 18:59
 * @Version 1.0
 */
public class PropertiedRead {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        /*先实例化properties对象，再读取properties文件中的信息*/
        Properties properties = new Properties();
        /*实例化工具类*/
        FileUtils fileUtils = new FileUtils();
        /*定义一个集合存储students.properties文件中的键值对*/
        Map<String, String> stuMessOfStudentsProperties = fileUtils.propertiesRead("Java\\src\\JavaSE\\day17\\work\\students.properties");
        System.out.println("从文件中读取到的所有键值对信息："+stuMessOfStudentsProperties);
        /*获取className,根据className实例化Class对象*/
        /*获取stuMessOfStudentsProperties的所有key*/
        Set<String> allKey = stuMessOfStudentsProperties.keySet();
        String className = stuMessOfStudentsProperties.get("className");
        Class c = Class.forName(className);
        /*根据获取的类对象实例化*/
        Object o = c.newInstance();
        /*获取该自己声明的所有属性*/
        Field[] allFields = c.getDeclaredFields();
        for (Field everyField: allFields
             ) {
            everyField.setAccessible(true); // 暴力反射，可以直接获取和修改私有属性的值
            String everyFieldName = everyField.getName();
            /*根据属性名匹配文件中的属性值*/
            for (String everykey: allKey
                 ) {
                if (everykey.substring(everykey.indexOf(".")+1).equals(everyFieldName)){ // 文件中的每个属性名于class中属性名相等时
                    String everyFieldValue = stuMessOfStudentsProperties.get(everykey); // 根据Class中的属性获取文件对象属性的值
                    if (everyField.getType().equals(int.class)){ // 判断文件中的属性值是否是int型，如果是则将从文件中得的到属性值强转成int
                        int value = Integer.parseInt(everyFieldValue);
                        everyField.set(o, value); // 赋值给对象
                    }
                    else if (everyField.getType().equals(double.class)) {
                        double value = Double.parseDouble(everyFieldValue);
                        everyField.set(o, value);
                    }else {
                        everyField.set(o, everyFieldValue);
                    }
                    break;
                }
            }
        }
        System.out.println("初始化后的对象："+o);
    }
}
