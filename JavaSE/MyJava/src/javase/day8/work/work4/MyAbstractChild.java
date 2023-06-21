package javase.day8.work.work4;

/**
 * @ClassName MyAbstractChild
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/15 20:12
 * @Version 1.0
 */
class MyAbstractChild<E> extends MyAbstract<E> {
    @Override
    public void print(E e) {
        System.out.println(e.getClass());
    }
}
