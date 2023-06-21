package javase.day11.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName MapDemo
 * @Description Map是泛型接口 Mao用于存储键值对 键：唯一表示对象或者值的属性；值：就是键对应的值
 * @Author Cunhao Fan
 * @Date 2023/4/19 9:50
 * @Version 1.0
 */
/*学生模版类*/
class Student{
    String stuNo;
    String stuName;

    public Student(String stuNo, String stuName) {
        this.stuNo = stuNo;
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
public class MapDemo {
    /*HashMap 异步实现，线程安全*/
    public static void main(String[] args) {
        /*存储学生学号和姓名的关系：学号是键，姓名是值*/
        Map<String,String> map = new HashMap<String,String>();
        /*常用方法**map.put(key,value) 如果该Key在map中没有对应关系，那么设置值；如果有，那么就是修改键的值*/
        map.put("001","张三");
        map.put("001","李四");
        map.put("002","李四");
        System.out.println(map);
        /*常用方法**map.get(key) 根据键获取值*/
        String value = map.get("001");
        System.out.println("键对应的值"+value);
        /*常用方法Set<K> = **map.kySet()*/
        Set<String> allKey = map.keySet();
        System.out.println("map中所有的key："+allKey);
        /*forEach遍历*/
        for (String everyKey:allKey
             ) {
            String valueKey = map.get(everyKey);
            System.out.println("学号是："+everyKey+", 姓名是："+valueKey);
        }
        /*迭代器遍历*/
        /*获取迭Set的代器*/
        Iterator <String> iterator = allKey.iterator();
        while (iterator.hasNext()){
            /*获取每一个键*/
            String everyKey = iterator.next();
            /*根据每一个键获取每一个键值*/
            String everyValue = map.get(everyKey);
            System.out.println("学号是："+everyKey+", 姓名是："+everyValue);
        }


        /*存储学生学号和姓名的关系：学号是键，学生对象是值*/
        Map<String,Student> studentMap = new HashMap<String,Student>();
        Student student1 = new Student("01","张三");
        Student student2 = new Student("02","李四");
        studentMap.put("01",student1);
        studentMap.put("02",student2);
        MapDemo mapDemo = new MapDemo();
        /*调用遍历方法(集合作为参数)*/
        mapDemo.forEach(studentMap);
        /*遍历并删除目标对象*/
        mapDemo.IteratorTraverse(studentMap);

    }
    /*遍历方法*/
    public void forEach (Map<String,Student> map) {
        /*获取所有的key*/
        Set <String> stuAllKey = map.keySet();
        /*遍历所有的key*/
        for (String everyKey:stuAllKey
             ) {
            Student everyStu = map.get(everyKey);
            System.out.println("学号："+everyKey+", 学生："+everyStu.stuName);
        }
    }
    public void IteratorTraverse (Map<String,Student> map) {
        /*获取所有的key*/
        Set <String> stuAllKey = map.keySet();
        /*遍历所有的key*/
        /*获取迭代器*/
        Iterator <String> iterator = stuAllKey.iterator();
        while (iterator.hasNext()){
            String everyKey = iterator.next();
            Student everyStu= map.get(everyKey);
            /* 移除张三*/
            if (everyStu.stuName.equals("张三")) {
                iterator.remove();
            }
            else {
                System.out.println("张三已被移除！");
                System.out.println("学号："+everyKey+", 学生："+everyStu.stuName);
            }
        }

    }
}
