package javase.day8.work;

/**
 * @ClassName Work2
 * @Description 编写自定义异常MyException类重写打印错误信息方法实现打印"你输入有问题“
 * @Author Cunhao Fan
 * @Date 2023/4/15 11:42
 * @Version 1.0
 */
public class Work2 extends Exception{
    @Override
    public void printStackTrace() {
        System.err.println("你输入有问题");
    }
}
