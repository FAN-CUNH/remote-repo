package javase.day18.unit_work.reflect_work;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName Reflect_1
 * @Description 1. 现有集合：ArrayList list = new ArrayList();
 *              2. 利用反射机制在这个泛型为Integer的ArrayList中存放一个String类型的对象。
 * @Author Cunhao Fan
 * @Date 2023/5/3 15:12
 * @Version 1.0
 */
public class Reflect_1 {
    public static void main(String[] args) throws Exception{
        ArrayList<Integer> list = new ArrayList<Integer>();
        Class c = list.getClass();
        System.out.println(c);
        Method method = c.getMethod("add", Object.class);
        Method[] methods = c.getMethods();
        System.out.println(methods.length);
        System.out.println(Arrays.toString(methods));
        System.out.println(method.getName());
        method.invoke(list, "123");
        System.out.println(list.get(0));
    }
}
