package javase.day14.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployWork {
    public static void main(String[] args) {
        ArrayList<Employ> employs = new ArrayList<>();
        Employ employ = new Employ("01",8900,"zhangsan");
        Employ employ1 = new Employ("01",7900,"zhangsan");
        employs.add(employ);
        employs.add(employ1);
        //将员工按照工资由高到低排序，显示名字:forEach
        Collections.sort(employs,((o1, o2) -> (int) (o2.getSal()*100 - o1.getSal()*100)));

        employs.forEach(everyEmp-> System.out.println(((Employ)everyEmp).getEmpName()));

        //筛选员工中工资高于8000的人，并形成新的集合:过滤 + 流转集合的方法
        Stream streamList = employs.stream();
        Predicate<Employ> predicate1 = (e)->e.getSal()>8000;
        streamList = streamList.filter(predicate1);
        List<Employ> list = (List<Employ>) streamList.collect(Collectors.toList());
        System.out.println("新的集合："+list);



       //筛选出Integer集合中大于7的元素，并打印，例如6,7,3,8,1,2,9:filter
        List<Integer> numbers = Arrays.asList(new Integer[]{6,7,3,8,1,2,9});
        Stream stream = numbers.stream();
        Predicate<Integer> predicate = numer1->numer1 > 7;
        stream.filter(predicate).forEach(System.out::println);

    }
}
