package javase.day18.unit_work.annotation_work;

import java.lang.reflect.Method;

/**
 * @ClassName Book_Test
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/3 20:31
 * @Version 1.0
 */
public class Book_Test {
    @Book(value = "智能文档技术研究", price = 200, authors = {"范存浩", "王帅"})
    public void read() {
    }

    public static void main(String[] args) throws Exception{
        Class c = Book_Test.class;
        Method method = c.getDeclaredMethod("read");
        System.out.println(method.getName());
        /*Annotation[] a = method.getAnnotations();
        System.out.println(Arrays.toString(a));*/
        if (method.isAnnotationPresent(Book.class)){
            System.out.println(method.getDeclaredAnnotation(Book.class));
        }
    }
}
