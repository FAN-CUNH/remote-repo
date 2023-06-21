package javase.day8.work.work4;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/15 20:04
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        MyInterface<String> myInterface = new MyInterfaceChild<>();
        myInterface.print("12.35454");
        MyAbstract <Integer> myAbstract = new MyAbstractChild<>();
        myAbstract.print(12213135);
    }
}
