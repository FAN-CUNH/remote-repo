package javase.day18.dynamicproxy;

/**
 * @ClassName DailyRecordMess
 * @Description 日志信息 编写辅助功能
 * @Author Cunhao Fan
 * @Date 2023/4/27 19:47
 * @Version 1.0
 */
public class DailyRecordMess {
    /*前置日志*/
    public void Before (Object[] args, String method) {
        System.out.println("日志：the method "+method+" begin with ["+args[0]+", "+args[1]+"]");
    }
    /*后置日志*/
    public void After (String method, int result) {
        System.out.println("日志：the method "+method+" after with ["+result+"]");
    }
}
