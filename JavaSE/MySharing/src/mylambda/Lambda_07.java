package mylambda;

interface MyInterface {
    /**
     * @Description 输出一串字符串
     * @param printMess 要输出的字符串
     * @return void
     * @Author CunHao Fan
     * @Date 2023/5/14 22:07
     */
    public void doSomeThing(String printMess);
}

    /**
     * @ClassName Lambda_07
     * @Description 使用Lambda表达式进行函数式接口的实现
     * @Author CunHao Fan
     * @Date 2023/5/13 13:33
     * @Version 1.0
     */
public class Lambda_07 {
    public static void main(String[] args) {
        /*未使用Lambda表达式*/
        MyInterface myinterface = new MyInterface() {
            @Override
            public void doSomeThing(String printMess) {
                System.out.println(printMess);
            }
        };
        myinterface.doSomeThing("Hello World");
        System.out.println("================================");
        /*使用Lambda表达式*/
        MyInterface myInterface1 = System.out::println;
        myInterface1.doSomeThing("Hello World");
    }
}
