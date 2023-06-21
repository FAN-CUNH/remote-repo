package javase.day13.test;

import java.util.function.Consumer;

/**
 * @ClassName ConsumerDemo
 * @Description Consumer<T> 消费型接口 抽象方法accept（T t）
 * @Author Cunhao Fan
 * @Date 2023/4/21 11:21
 * @Version 1.0
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        /*按照格式姓名：XX。性别：XX。的格式将信息打印出来*/
        String[] nameArray = {"张三,女", "李四,女", "王二麻,男"};
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s.split(",")[0]+" ");
                System.out.println(s.split(",")[1]);
            }
        };
        for (String everyMess:nameArray
             ) {
            consumer1.accept(everyMess);
        }
        /*先打姓名，再打性别*/
        Consumer<String> consumer2 = name -> System.out.print(name.split(",")[0]+" ");
        Consumer<String> consumer3 = name -> System.out.println(name.split(",")[1]);
        for (String everyMess :nameArray
             ) {
            consumer2.andThen(consumer3).accept(everyMess);
        }
    }
}
