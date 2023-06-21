package javase.day16.studentmanage;

import javautils.FileUtils;

import java.util.List;
import java.util.Scanner;

/**
 * @ClassName test
 * @Description # 封装Student,属性String stuNo;String stuName;封装学生的注册方法：完成将学生信息注册到E:students.txt文件
 *              # 注意学号和姓名不能重复；封装学生的登录方法根据学号和姓名登录，如果登录成功展示学生的全部信息
 *              # 封装学生的删除信息方法：根据学生学号删除学生信息
 * @Author Cunhao Fan
 * @Date 2023/4/25 19:21
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        /*定义一个集合用于存储学生文件信息*/
        FileUtils fileUtils = new FileUtils();
        List<String> strOfStuMess = fileUtils.bufferedReaderFile("java\\src\\JavaSE\\day16\\studentmanage\\student.txt");
        Scanner scanner = new Scanner(System.in);
        while (true) { // 主界面
            System.out.println("---------------------------------------------------------------");
            System.out.println("\t\t\t\t\t欢迎进入学生管理系统");
            System.out.println("\t\t1：注册 \t\t2：登录 \t\t3：删除学生 \t\t4：退出");
            System.out.println("请选择你要选择的服务：");
            String choose = scanner.next();
            main:switch (choose) {
                case "1":{ // 注册
                    /*实例化注册模板类*/
                    StuRegister stuRegister = new StuRegister();
                    /*获取注册学生信息*/
                    boolean isNotRegisterSuccess = true; // 标记 假设不能注册成功
                    while (isNotRegisterSuccess){ // 注册成功则结束循环
                        System.out.println("请输入学生学号和姓名：");
                        String stuNo = scanner.next();
                        String stuName = scanner.next();
                        if (stuNo.matches("\\d{3}") && stuName.matches("\\w+")){ // 学号必须为纯数字,姓名必须是数组字母下划线
                            stuRegister.register(stuNo,stuName,strOfStuMess);
                            System.out.println("是否继续注册？ 1：是 其他：否");
                            String choose1 = scanner.next();
                            boolean isSucc1 = choose1.matches("[1-2]{1}");
                            if (isSucc1 && choose1.equals("1")) { // 当输入1时继续注册
                                isNotRegisterSuccess = true;
                            }else {
                                isNotRegisterSuccess = false;
                            }
                        }else { // 格式不正确，并要求重复输入
                            System.out.println("学生信息输入有误！请重新输入：");
                        }
                    }
                    break;
                }
                case "2":{ // 登录
                    StuLoad load = new StuLoad();
                    boolean isLoad = true;
                   while (isLoad) {
                       boolean isSucc2 = false;
                       System.out.println("请输入学号：");
                       String stuNo = scanner.next();
                       isSucc2 = stuNo.matches("\\d{3}");
                       if (isSucc2){
                           load.load(stuNo);
                           System.out.println("是否继续登录？ 1：是 其他：否");
                           String choose2 = scanner.next();
                           boolean isSucc3 = choose2.matches("[1-2]{1}");
                           if (isSucc3 && choose2.equals("1")) {
                               isLoad = true;
                           }else {
                               isLoad = false;
                           }
                       }else {
                           System.out.println("学号输入有误！重新输入");
                           isLoad = true;
                       }
                   }
                   break;
                }
                case "3": { // 删除
                    StuDelete stuDelete = new StuDelete();
                    boolean isDelete = true;
                    while (isDelete) {
                        System.out.println("请输入要删除学生的学号：");
                        boolean isSucc4 = false;
                        String stuNo = scanner.next();
                        isSucc4 = stuNo.matches("\\d{3}");
                        if (isSucc4) {
                            stuDelete.stuDelete(stuNo);
                            System.out.println("是否继续删除学生？ 1:是 其他：否");
                            String choose3 = scanner.next();
                            boolean isSucc5 = choose3.matches("[1-2]{1}");
                            if (isSucc5 && choose3.equals("1")) {
                                isDelete = true;
                            } else {
                                isDelete = false;
                            }
                        } else {
                            System.out.println("学生学号输入有误！请重新输入：");
                            isDelete = true;
                        }
                    }
                    break;
                }
                case "4":{ // 退出
                    System.exit(0); //表示正常结束程序
                    //return; 效果相同
                }
                default:{
                    System.out.println("没有该服务！请重新选择！");
                }
            }
        }
    }
}
