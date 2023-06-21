package javase.day7.work.studentmanagementsystem;

import java.util.Arrays;

public class Student {
    private String stuNo;
    private String stuName;
    private String stuId;
    private String stuAge;
    private  Course[] courses;//可以选择的所有课程
    private  int courseCount = 0;//学生已经选择的课程门数
    /*构造方法*/

    public Student(String stuNo, String stuName, String stuId, String stuAge, Course[] courses, int courseCount) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuId = stuId;
        this.stuAge = stuAge;
        this.courses = new  Course[3];
        this.courseCount = courseCount;
    }

    public Student() {
        courses = new  Course[3];
    }
    /*setget方法*/

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    //选课：不可以重复添加

    public void addCourse (Course course){
        /*判断course是否存在课程数组中*/
        boolean isExist = false;
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCouName().equals(course.getCouName())){
                System.out.println("已经选课，不能重选!");
                isExist = true;
                break;
            }
        }
        if (!isExist){
            if (getCourseCount() != 3){
                System.out.println("选课成功！"+course.getCouName());
                courses[courseCount] = course;
                courseCount++;
            }else{
                System.out.println("该学生已经选择3三门课程，不可再选！");
            }
        }
    }


    //退选：根据课程编号退选
    public int delCourse (String couNo) {
        /*录入的课程号要求三位且切以00开头*/
        int isSuccessDel = -1;
        String regex = "^[0]{2}[1-4]{1}";
        if (couNo.matches(regex)){
            if (courseCount != 0) {
                Course course = null;
                for (int i = 0; i < courseCount; i++) {
                    if (courses[i].getCouNo().equals(couNo)) {
                        course = courses[i];
                        for (int j = i; j < courseCount; j++) {
                            courses[j] = courses[j + 1];
                        }
                        System.out.println(course.getCouName() + "退选成功");
                        isSuccessDel = 1;
                        courseCount--;
                        break;
                    } else if (i == courseCount - 1 && !(courses[i].getCouNo().equals(couNo))) {
                        System.out.println("查无此课");
                        break;
                    }
                }
            }else {
                System.out.println("当前学生未选课！不能退选,返回到登录界面");
                isSuccessDel = -777;
            }
        }else {
            System.out.println("课程名格式不正确!");
        }
        return isSuccessDel;
    }

    @Override
    public String toString() {
        return "{ " +
                "学号:" + stuNo +
                ", 姓名:" + stuName +
                ", 年龄:" + stuAge +
                ", 已选课程:" + Arrays.toString(courses) +
                " }";
    }
}
