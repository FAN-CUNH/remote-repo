package javase.day14.test;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateWork {
    public static void main(String[] args) {
        //Predicate   boolean = test(T e)
        //negate()
        Predicate<String> predicate = (name) -> name.matches("[\\d\\D]*[0-9]+[\\w\\W]*");
        boolean isContainNumer = predicate.test("777hgtrht");
        System.out.println("是否包含数字：" + isContainNumer);
        boolean isContainNumer1 = predicate.negate().test("777hgtrht");
        System.out.println("刚刚结果的取反：" + isContainNumer1);

        /*//集合信息筛选  String[] array = { "张三,男", "李四,女", "王二麻子,女" };
数组当中有多条“姓名+性别”的信息如下，请通过Predicate接口的拼装将符合要求的字符串筛选到集合ArrayList中，需要同时满足两个条件：
1.必须为女生
2.姓名为4个字*/
        Predicate<String> predicate1 = everyStu1 -> everyStu1.substring(everyStu1.indexOf(",") + 1).equals("女");
        Predicate<String> predicate2 = everyStu1 -> everyStu1.substring(0, everyStu1.indexOf(",")).length() == 4;

        String[] array = {"张三,男", "李四,女", "王二麻子,女"};
        ArrayList<String> students = new ArrayList<>();
        for (String everyStu : array
        ) {
            //条件：and()   Predicate
            if (predicate1.and(predicate2).test(everyStu)) {
                students.add(everyStu);
            }
        }
        System.out.println("集合的数据：" + students);


    }
}
