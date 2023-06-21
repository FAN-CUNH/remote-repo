package javase.day16.studentmanage;

import javautils.FileUtils;

import java.util.List;

/**
 * @ClassName StuRegister
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/25 19:23
 * @Version 1.0
 */
public class StuRegister {
    public void register(String stuNo, String stuName, List<String> strOfStuMess) {
        /*实例化文件工具类*/
        FileUtils fileUtils = new FileUtils();
        /*判断当前学生是否已经存在，存在则返回该学生已存在，否则创建学生对象并将创建的学生信息写出students.txt文件*/
        boolean isExist = false;
        /*遍历学生信息集合*/
        for (String everyStuMess: strOfStuMess
             ) {
            if (everyStuMess.contains(stuNo+",")) { // 存在该学生，修改标记值
                isExist = true;
                System.out.println("该学生已存在！不能注册！");
                break;
            }
        }
        /*如果学生不存在，则执行注册操作*/
        if (!isExist) {
            /*先实例化学生，再将学生信息存入学生信息集合中*/
            Student student = new Student(stuNo,stuName);
            strOfStuMess.add(student.toString());
            /*将集合中信息写出到文件*/
            fileUtils.bufferedWriterFile(strOfStuMess,"java\\src\\JavaSE\\day16\\studentmanage\\student.txt",false);
            System.out.println("注册成功！");
        }
    }
}
