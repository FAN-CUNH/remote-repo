package javase.day8.work.work4;

/**
 * @ClassName MyInterfaceChild
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/15 20:06
 * @Version 1.0
 */
/*泛型接口的已知实现子类*/
class MyInterfaceChild <E> implements MyInterface<E>{
    @Override
    public void print(E e) {
        System.out.println(e.getClass());
    }
}