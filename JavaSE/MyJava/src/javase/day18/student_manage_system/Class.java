package javase.day18.student_manage_system;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Class
 * @Description 班级模版类
 * @Author Cunhao Fan
 * @Date 2023/4/28 10:31
 * @Version 1.0
 */
public class Class {
    /*私有成员变量*/
    private String className;
    private int classCapacity; // 班级容量,即最大学生数
    private List<Student> stuList = new ArrayList<Student>(); // 存放班级已有学生
    static int stuCount = 0;

    /*构造方法*/

    public Class(String className, int classCapacity, List<Student> stuList) {
        this.className = className;
        this.classCapacity = classCapacity;
        this.stuList = stuList;
    }

    public Class() {
    }
    /*setGet方法*/

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassCapacity() {
        return classCapacity;
    }

    public void setClassCapacity(int classCapacity) {
        this.classCapacity = classCapacity;
    }

    public List<Student> getStuList() {
        return stuList;
    }

    public void setStuList(List<Student> stuList) {
        this.stuList = stuList;
    }

    /**
     * @Description: 封装添加学生进入班级
     * @Param: [s ：要被添加的对象]
     * @Return: java.util.List ：返回学生集合
     * @Author: Cunhao Fan
     * @Data: 2023/4/28 16:09
     */
    public List<Student> addStudent(Student s) {
        if (stuList.contains(s) && classCapacity >= stuCount) {
            System.out.println("该学生已存在！");
        } else {
            int count = ++stuCount;
            s.setStuNo((count) + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss")) + (count));
            stuList.add(s);
        }
        return stuList;
    }

    /**
     * @Description: 封装删除班级中的学生
     * @Param: [s ；删除的目标对象]
     * @Return: java.util.List ：返回学生集合
     * @Author: Cunhao Fan
     * @Data: 2023/4/28 16:08
     */
    public List<Student> delStudent(Student s) {
        if (stuList.contains(s)) {
            stuList.remove(s);
        } else {
            System.out.println("没有此学生！");
        }
        return stuList;
    }

    /**
     * @Description: 封装修改班级学生姓名的方法
     * @Param: [stuNo :学号 , taggetName : 修改后的name]
     * @Return: java.util.List 返回学生集合
     * @Author: Cunhao Fan
     * @Data: 2023/4/28 16:12
     */
    public List<Student> modStudent(String stuNo, String taggetName) {
        Student student = null;
        for (int i = 0; i < stuList.size(); i++) {
            if (stuList.get(i).getStuNo().equals(stuNo)) {
                student = stuList.get(i);
            }
        }
        if (student != null) {
            student.setStuName(taggetName);
        } else {
            System.out.println("该学生不存在！");
        }
        return stuList;
    }

    public Map<String, Integer> countCourse() {
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0;
        Map<String, Integer> countCourse = new HashMap<>();
        for (Student everyStu : stuList) {
            for (Course everyCourse : everyStu.getCourses()) {
                switch (everyCourse.getCouName()) {
                    case "语文": {
                        count1++;
                        countCourse.put("语文", count1);
                        break;
                    }
                    case "数学": {
                        count2++;
                        countCourse.put("数学", count2);
                        break;
                    }
                    case "英语": {
                        count3++;
                        countCourse.put("外语", count3);
                        break;
                    }
                    case "物理": {
                        count4++;
                        countCourse.put("物理", count4);
                        break;
                    }
                    case "化学": {
                        count5++;
                        countCourse.put("化学", count5);
                        break;
                    }
                    case "生物": {
                        count6++;
                        countCourse.put("生物", count6);
                        break;
                    }
                }
            }
        }
        return countCourse;
    }
    /*重写toString方法*/

    @Override
    public String toString() {
        return "Class{" +
                "className='" + className + '\'' +
                ", classCapacity=" + classCapacity +
                ", stuList=" + stuList +
                '}';
    }
}
