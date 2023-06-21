package javase.day16.work1;

import javase.day15.work2.FileUtil;
import javase.day16.studentmanage.Student;

import java.util.List;

/**
 * @ClassName BufferedReaderWriterWork
 * @Description 往E:students.txt中添加一个学生信息，要求学号不能重复 修改学号为03的学生
 * @Author Cunhao Fan
 * @Date 2023/4/25 16:06
 * @Version 1.0
 */
public class BufferedReaderWriterWork {
    public static void main(String[] args) {
        /*实例化工具类*/
        FileUtil fileUtil = new FileUtil();
        /*声明一个集合用于接收读入的信息*/
        List<String> strOfStuMess = fileUtil.bufferedReaderFile("D:\\students.txt");
        Student student = new Student("04","mazi");
        /*判断学号是否存在*/
        boolean isExist = false;
        for (String everyStuMess: strOfStuMess
             ) {
            if (everyStuMess.contains(student.getStuNo()+",")) {
                isExist = true;
            }
        }
        if (!isExist) { // 不在集合中
            strOfStuMess.add(student.toString());
            fileUtil.BufferedWriterFile(strOfStuMess,"D:\\students.txt");
        }else {
            System.out.println("该学生已存在！");
        }
        /*修改*/
        for (int i = 0; i < strOfStuMess.size() ; i++) {
            if (strOfStuMess.get(i).contains("stuNo=03")) {
                strOfStuMess.set(i,"[stuNo=03,stuName=zhaoliu]");
            }
        }
        /*将修改后的集合写出*/
        fileUtil.BufferedWriterFile(strOfStuMess,"D:\\students.txt");
    }
}
