package javase.day19.thread_demo;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/4 11:09
 * @Version 1.0
 */
public class MyThread extends Thread{
    /*资源*/
    int i = 1;
    /*调用父类的有参构造*/
    public MyThread(String name) {
        super(name);
    }
    /*重写父类的run()方法*/
    @Override
    public void run() {
        /*表示任务需要做的事*/
        System.out.println(this.getName()+i);
    }
}
