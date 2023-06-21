package javase.day17.work;

import javautils.FileUtils;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PropertiesWrite
 * @Description # 将我们的类信息存在student.properties文件中，存储格式className=包名+类名；conPC = 2;conPT1 = String;
 *              # conPT2 = String;最后根据资源文件的信息选择调用某类相应的构造方法以及完成类的实例化
 * @Author Cunhao Fan
 * @Date 2023/4/26 20:17
 * @Version 1.0
 */
public class PropertiesWrite {
    public static void main(String[] args) throws ClassNotFoundException {
        /*实例化工具类*/
        FileUtils fileUtils = new FileUtils();
        Class c = Class.forName("javase.day17.test.Student");
        /*获取所有的构造器*/
        Constructor[] allConstructors = c.getConstructors();
        /*创建一个map用于存储student类中关系的键值对*/
        Map<String, String> constructorMess = new HashMap();
        int countConPC = 0;
        for (int i = 0; i < allConstructors.length; i++) {
            /*遍历每一个构造器，得到每个构造器的参数个数*/
            countConPC = allConstructors[i].getParameterCount();
            constructorMess.put("conPC"+(i+1), countConPC+"");
            /*获取每一个构造器的所有参数类型*/
            Class[] allParamType = allConstructors[i].getParameterTypes();
            for (int j = 0; j < allParamType.length; j++) {
                /*遍历每一个构造器的参数类型，将所有构造器存入集合*/
                constructorMess.put("conPC"+(i+1)+"的conPT"+(j+1), allParamType[j].getName());
            }

        }
        System.out.println(constructorMess);
        fileUtils.propertiesWrite(constructorMess,"java\\src\\JavaSE\\day17\\work\\student.properties");
    }
}
