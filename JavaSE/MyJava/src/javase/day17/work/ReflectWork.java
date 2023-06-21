package javase.day17.work;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName Work1
 * @Description 将某个类中的所有属性都获取出来同时统计其中私有属性的个数；
 *              统计属性类型是int类型的属性个数,
 *              统计属性名长度不大于4位同时是纯字母的属性的个数
 *              将某个类中的所有方法都获取到统计方法参数是2个的方法的个数，
 *              统计方法参数是int类型和double类型的个数
 * @Author Cunhao Fan
 * @Date 2023/4/26 16:42
 * @Version 1.0
 */
public class ReflectWork {
    public static void main(String[] args) throws ClassNotFoundException {
        /*获取到Class对象*/
        Class c = Class.forName("javase.day17.test.Student");
        /*获取Class对象的所有属性*/
        Field[] allFieldname = c.getDeclaredFields();
        /*声明2个计数器用来统计私有属性的个数和属性是int的变量*/
        int countPrivateField = 0, countIntField = 0, countOfAllChar = 0, countMethodParamis2 = 0, countMethodParamIsIntAndDouble = 0;
        /*遍历所有的属性*/
        for (Field everyField: allFieldname
             ) {
            everyField.setAccessible(true); // 暴力反射，设置为可以直接访问私有类型的属性
            if (everyField.getModifiers() == 2) { // 属性的权限修饰符 0:缺省的 1:公共的 2:私有的 4:被保护的
                countPrivateField++;
            }
            if (everyField.getType() == int.class) { // 属性的类型是否为int
                countIntField++;
            }
            if (everyField.getName().length() > 4 && everyField.getName().matches("[a-zA-Z]+")) {
                countOfAllChar++;
            }
        }
        /*获取Class对象的所有方法*/
        Method[] allMethods = c.getMethods();
        System.out.println("所有方法个数："+allMethods.length);
        for (Method everyMethod: allMethods
             ) {
            if (everyMethod.getParameterCount() == 2) { // 方法参数个数是2
                countMethodParamis2++;
                if (everyMethod.getParameterTypes()[0] == int.class && everyMethod.getParameterTypes()[1] == double.class ||
                everyMethod.getParameterTypes()[1] == int.class && everyMethod.getParameterTypes()[0] == double.class) {
                    countMethodParamIsIntAndDouble++;
                }
            }
        }
        System.out.println("私有属性个数："+countPrivateField+", int类型属性个数："+countIntField+", 属性名大于4且纯字母的属性个数："+countOfAllChar);
        System.out.println("参数是2个的方法个数："+countMethodParamis2+", 参数是int型和double型的方法个数："+countMethodParamIsIntAndDouble);
    }
}
