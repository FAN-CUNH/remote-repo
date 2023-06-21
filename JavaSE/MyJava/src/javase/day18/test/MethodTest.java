package javase.day18.test;


import javase.day17.test.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest {
    //getMethod(String methodName)
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //获取Student类中setStuNo方法,同时参数是String和int,是public修饰
        //1 获取Class
        Class c = Student.class;
        //2 可以获取所有的Method
        Method[] allPublicMethods = c.getMethods();
        Method search = null;
        for (Method everyPublicM1:allPublicMethods
             ) {
            String methodName = everyPublicM1.getName();//获取的方法名
            if(methodName.equals("getStuNo") && everyPublicM1.getParameterCount() == 0){
                //获取改方法的参数
                search = everyPublicM1;
            }
        }
        System.out.println("你找到的方法："+search);
        if(search != null){
            //调用方法
            System.out.println("你找到了");
            //[调用：方法的返回值 = invoke(方法所在的对象,实际参数);  没有参数：实际参数就是null]
            Object o = c.newInstance();
            Object result =  search.invoke(o,null);//调用o对象中的search方法
            System.out.println(search.getName()+"方法的返回值="+result);
            System.out.println("调用完方法后的对象:"+o);

        }

    }
}
