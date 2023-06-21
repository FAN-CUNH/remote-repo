package javase.day18.student_manage_system;

import javautils.FileUtils;

import java.io.File;
import java.util.*;

/**
 * @ClassName StudentManageSystemTest
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/28 10:40
 * @Version 1.0
 */
public class StudentManageSystemTest {
    public static void main(String[] args) {
        /*实例化班级对象 参数分别是 班级名， 班级容量， 班级已有学生数组*/
        Class class1 = new Class("三年一班", 30, new ArrayList<>());
        Class class2 = new Class("三年二班", 30, new ArrayList<>());
        /*实例化课程对象 参数分别是 课程号， 课程名称， 课程分数*/
        Course chinese = new Course("001", "语文", 150);
        Course mathematics = new Course("002", "数学", 150);
        Course english = new Course("003", "英语", 150);
        Course physics = new Course("004", "物理", 100);
        Course chemistry = new Course("005", "化学", 100);
        Course biologic = new Course("006", "生物", 100);
        Course geography = new Course("007", "地理", 100);
        Course history = new Course("008", "历史", 100);
        Course politics = new Course("009", "政治", 100);
        /*班级可选课程名数组*/
        String[] allCanOptionalCourseNamesOfClass1 = {chinese.getCouName(), mathematics.getCouName(), english.getCouName(), physics.getCouName(), chemistry.getCouName(), biologic.getCouName()};
        String[] allCanOptionalCourseNamesOfClass2 = {chinese.getCouName(), mathematics.getCouName(), english.getCouName(), geography.getCouName(), history.getCouName(), politics.getCouName()};
        /*创建集合存储班级名和班级所可选课程信息*/
        Map<String, String> classNameWithAllCoursesOfCanOptional = new HashMap<>();
        /*将班级名和班级可选课程名形成的键值对写出到courses.properties文件*/
        classNameWithAllCoursesOfCanOptional.put(class1.getClassName(), Arrays.toString(allCanOptionalCourseNamesOfClass1));
        classNameWithAllCoursesOfCanOptional.put(class2.getClassName(), Arrays.toString(allCanOptionalCourseNamesOfClass2));
        /*实例化工具类*/
        FileUtils fileUtils = new FileUtils();
        /*利用工具类生成文件*/
        File coursesPropertiesFile = fileUtils.createFile("java\\src\\JavaSE\\day18\\student_manage_system\\courses.properties");

        Map<String, String> coursesOfCanOptional = fileUtils.propertiesRead(coursesPropertiesFile.getAbsolutePath());
        if (coursesOfCanOptional.size() == 0){
            fileUtils.propertiesWrite(classNameWithAllCoursesOfCanOptional, coursesPropertiesFile.getAbsolutePath());
        }else {
            System.out.println(fileUtils.propertiesRead(coursesPropertiesFile.getAbsolutePath()));
        }

        /*实例化学生*/

        Student student1 = new Student("张三", 18, Sex.男, new ArrayList<>());
        Student student2 = new Student("李四", 18, Sex.女, new ArrayList<>());
        Student student3 = new Student("王二", 18, Sex.男, new ArrayList<>());
        Student student4 = new Student("麻子", 18, Sex.男, new ArrayList<>());
        /*将学生放入班级的学生集合中*/
        class1.addStudent(student1);
        class1.addStudent(student2);
        class1.addStudent(student3);
        class1.addStudent(student4);
        class1.delStudent(student3);
        class1.delStudent(student2);
        class1.modStudent(student4.getStuNo(), "mazi");
        student1.addCousre(chinese);
        student1.addCousre(english);
        student1.addCousre(mathematics);
        student2.addCousre(chinese);
        student2.addCousre(english);
        student2.addCousre(mathematics);
        System.out.println(class1.countCourse());
        File classStudentMessFile = fileUtils.createFile("java\\src\\JavaSE\\day18\\student_manage_system\\"+class1.getClassName()+".txt");
        /*存储从班级学生信息文件中读取的信息*/
        List<String> stuMess = new ArrayList<>();
        fileUtils.bufferedWriterFile2(class1.getStuList(), classStudentMessFile.getAbsolutePath(), false);
        stuMess = fileUtils.bufferedReaderFile(classStudentMessFile.getAbsolutePath());
        /*将学生用到的最大学号放入stuNos.txt*/
        File stuNosFile= fileUtils.createFile("java\\src\\JavaSE\\day18\\student_manage_system\\stuNos.txt");
        /*获取班级学生信息集合中的所有学号*/
        String [] allStuNo = new String[stuMess.size()];
        if (allStuNo.length != 0) {
            for (int i = 0; i < stuMess.size(); i++) {
                allStuNo[i] = (stuMess.get(i).substring(stuMess.get(i).indexOf("=")+1, stuMess.get(i).indexOf(",")));
                System.out.println(allStuNo[i]);
            }
            fileUtils.writeFile(Class.stuCount+"", stuNosFile.getAbsolutePath());
        }else {
            System.out.println("当前还没有学生！");
        }
    }
}
