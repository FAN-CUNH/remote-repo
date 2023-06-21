package javase.day8.test.generic;

/**
 * @ClassName GenericDemo
 * @Description 泛型：当我们需要类型作为变量使用的时候 泛型的结构：<E,F> <E> 泛型方法必须存在泛型类中，泛型类中可以没有泛型方法
 * @Author Cunhao Fan
 * @Date 2023/4/15 14:30
 * @Version 1.0
 */
public class GenericDemo  {
    /*泛型方法*/
    public static void main(String[] args) {
        MyInterface <String> myInterface = new MyInterfaceChile<>();
        myInterface.add("3165435");
        MyGeneric<Integer,Double> myGeneric = new MyGeneric<Integer, Double>();
        myGeneric.print(12,25.1211151);
    }
    /*泛型通配符*/
    /*<?> 用来表示不知道E是什么类型*/
}
/*泛型实体类类*/
class MyGeneric <E,F>{
    /*泛型方法*/
    public void print(E a, F b){
        System.out.println(a.getClass());
        System.out.println(b.getClass());
    }
}
/*泛型接口*/
interface MyInterface <E> {
    /*接受任意类型数据*/
    Object [] mess = new Object[10];
    public void add(E e);
}
/*泛型接口的已知实现子类*/
class MyInterfaceChile <E> implements MyInterface <E>{
    @Override
    public void add(E e) {
        System.out.println(e);
    }
}
