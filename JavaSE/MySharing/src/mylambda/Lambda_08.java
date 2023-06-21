package mylambda;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import java.util.ArrayList;

/**
 * @ClassName Lambda_08
 * @Description 使用Lambda表达式进行线程的创建
 * @Author Cunhao Fan
 * @Date 2023/5/13 13:42
 * @Version 1.0
 */
public class Lambda_08 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 is running!");
                System.out.println("=================================================");
            }
        });
        thread1.start();
        /*使用Lambda表达式*/
        Thread thread2 = new Thread(() -> System.out.println("Thread2 is running!"));
        thread2.start();

    }
}
