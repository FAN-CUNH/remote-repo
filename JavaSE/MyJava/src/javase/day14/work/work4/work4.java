package javase.day14.work.work4;

import java.util.*;
import java.util.stream.Stream;

/**
 * @ClassName work4
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/23 18:23
 * @Version 1.0
 */
/*员工模板类*/
class Employ {
    private int wage;
    private int age;

    public Employ(int wage, int age) {
        this.wage = wage;
        this.age = age;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "wage=" + wage +
                '}';
    }

}
public class work4 {
    public static void main(String[] args) {
    /*1.练习Stream中的常用方法of()、iterate()、generate()、findFirst()、findAny()、anyMatch()、distinct()等*/

    /*2.筛选出Integer集合中大于7的元素，并打印，例如6,7,3,8,1,2,9*/
        Integer[] integers = {6,7,3,8,1,2,9};
        /*获取Stream流*/
        Stream<Integer> stream = Arrays.stream(integers);
        /*filter()方法 forEach()方法*/
        stream.filter(integer -> integer > 7).forEach(System.out::println);
        /*关闭stream流*/
        stream.close();
    /*3.筛选员工中工资高于8000的人，并形成新的集合*/
        /*实例化三个员工*/
        Employ employ1 = new Employ(10000,21);
        Employ employ2 = new Employ(6000,22);
        Employ employ3 = new Employ(6000,23);
        ArrayList<Employ> employs = new ArrayList<Employ>(Arrays.asList(employ1,employ2,employ3));
        /*获取stream流*/
        Stream<Employ> stream1 = employs.stream();
        /*实例化一个集合用于存储符合条件的员工信息*/
        ArrayList<Employ> employs1 = new ArrayList<>();
        stream1.filter(employ -> employ.getWage() > 8000).forEach(employ -> employs1.add(employ));
        System.out.println(employs1);
        stream1.close();
    /*4.获取String集合中最长的元素 */
        ArrayList<String> strings = new ArrayList<String>(Arrays.asList("abc","abcd","abcde","abcdef"));
        /*获取Strings的流*/
        Stream<String> stream2 = strings.stream();
        /*调用max()方法*/
        Optional<String> optionalS1 = stream2.max(Comparator.comparing(String::length));
        //Optional<String> optionalS2 = stream2.max(String::indexOf);
        /*调用get()方法获取值*/
        System.out.println(optionalS1.get());
        //System.out.println(optionalS2.get());
    /*5.获取Integer集合中最大值*/
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Optional<Integer> optional = list.stream().max(Integer::compareTo);
        System.out.println(optional.get());
        list.stream().close();
    /*6.获取员工工资最高的人*/
        Optional<Employ> employ = employs.stream().max(Comparator.comparing(Employ::getWage));
        System.out.println(employ.get().getWage());
    /*7.计算Integer集合中大于6的元素的个数*/
        long count = list.stream().filter(integer -> integer > 6).count();
        System.out.println(count);
    /*8.将员工按照工资由低到高排序，显示名字*/
    /*9.将员工按照工资由高到低排序，显示名字*/
        ArrayList<Employ> employs2 = new ArrayList<>();
        employs.stream().forEach(employ4 -> employs2.add(employ4));
        Collections.sort(employs2,Comparator.comparing(Employ::getWage));
        System.out.println(employs2);
        Collections.sort(employs2,(o1, o2) -> o2.getWage() - o1.getWage());
        System.out.println(employs2);
    /*10.将员工按照工资由低到高（工资一样则按年龄由小到大）排序，显示名字 */
        Collections.sort(employs2,(o1, o2) -> {
            if (o2.getWage() == o1.getWage()){
                return o1.getAge() - o2.getAge();
            }
            return o1.getWage() - o2.getWage();
        });
        employs2.stream().forEach(employ4 -> System.out.println(employ4.getWage()+" "+employ4.getAge()));
    /*1.将英文字符串的数组中的元素全部变为大写，以集合输出。将整数的数组中的元素全部加3，以集合输出*/
        String[] s = {"abc","abcd","abcde","abcdef"};
        Stream.of(s).forEach(everys -> System.out.print(everys.toUpperCase()+" "));
        Stream.of(integers).forEach(everyint -> System.out.println(everyint+3));
    /*2.统计员工人数、平均工资、工资总额、最高工资、统计工资的所有信息 counting() 、averagingDouble()、maxBy()、summingInt()、summarizingDouble()*/
    }
}
