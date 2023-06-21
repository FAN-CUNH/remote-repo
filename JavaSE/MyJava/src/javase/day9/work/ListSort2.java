package javase.day9.work;

import java.util.*;

/**
 * @ClassName ListSort2
 * @Description 自定义人类:包含姓名,年龄,身高属性.私有成员变量,生成无参,有参构造方法,生成get/set方法.创建5个人对象放到ArrayList中.使用迭代器获取每个人对象.将每个人的年龄加2岁.再使用增强for打印每个人的信息
 * @Author Cunhao Fan
 * @Date 2023/4/17 20:45
 * @Version 1.0
 */

/*创建人类模版类*/
class Person{
    private String name;
    private int age;
    private int tall;

    public Person(String name, int age, int tall) {
        this.name = name;
        this.age = age;
        this.tall = tall;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTall() {
        return tall;
    }

    public void setTall(int tall) {
        this.tall = tall;
    }
    /*重写toString*/

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tall=" + tall +
                '}';
    }
}

public class ListSort2 {
    /*自定义排序方法，按学生年龄排序*/
    public void sort (List <Person> people){
        /*Collections.sort(集合,比较器)*/
        Collections.sort(people, new Comparator<Person>() {
            @Override
            /*按年龄从小到大排序*/
            /*
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
            */
            /*按姓名从小到大排序*/
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
    public static void main(String[] args) {
        /*实例化五个人*/
        Person person1 = new Person("z张三",25,177);
        Person person2 = new Person("l李四",21,175);
        Person person3 = new Person("w王二",23,173);
        Person person4 = new Person("m麻子",24,178);
        Person person5 = new Person("z赵六",20,182);
        /*实例化人类集合*/
        List<Person> personList = new ArrayList<Person>(Arrays.asList(person1,person2,person3,person4,person5));
        /*实例化本类对象*/
        ListSort2 listSort2 = new ListSort2();
        listSort2.sort(personList);
        /*获取迭代器*/
        Iterator <Person> iterator = personList.iterator();
        /*循环判断当前对象后是否还有对象，有则获取对象*/
        /*迭代器获取和修改集合元素
        while (iterator.hasNext()){
            Person person = iterator.next();
            person.setAge(person.getAge()+2);
        }
        */
        /*for+get获取和修改集合元素*/
        for (int i = 0; i < personList.size(); i++) {
            personList.get(i).setAge(personList.get(i).getAge()+2);
        }
        /*使用增强型for循环打印学生信息*/
        /*
        for (Person everyStudent:personList
             ) {
            System.out.println(everyStudent);
        }
        */
        /*迭代器遍历*/
        /*获取迭代器*/
        /*循环判断当前对象后是否还有对象，有则获取对象*/
        /*迭代器获取和修改集合元素*/
        while (iterator.hasNext()){
            Person person = iterator.next();
            System.out.println(person);
        }
    }
}
