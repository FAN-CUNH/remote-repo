package javase.day6.work.work8;

/**
 * @ClassName StudentClass
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/13 20:45
 * @Version 1.0
 */
public class StudentClass {
    /*私有成员变量*/
    private String classNo;
    private String className;
    private Student[] students; // 存放班级所有学生
    private String[] courseNames = {"语文","数学","英语"};
    /*构造方法*/
    public StudentClass(String classNo, String className) {
        this.classNo = classNo;
        this.className = className;
        this.students = new Student[3];
    }
    public StudentClass() {
        students = new Student[3];
    }
    /*setget方法*/
    public String getClassNo() {
        return classNo;
    }
    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public Student[] getStudents() {
        return students;
    }
    public void setStudents(Student[] students) {
        this.students = students;
    }

    /*添加学生*/
    int studentCount = 0;
    public void addStudent(Student student){
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStuNo().equals(student.getStuNo())){
                System.out.println("重复添加！");
            }
        }
        students[studentCount] = student;
        studentCount++;
    }

    /*各门课程被选择的次数*/
    /*取出每一个学生对象，再取出每个学生对象的课程数组，遍历数组中的课程，统计每个课程出现的次数*/
    public void printAllCoursesName(){
        /**/
        int count1  = 0;
        int count2  = 0;
        int count3  = 0;
        for (int i = 0; i < getStudents().length; i++) {
            Course[] courses = students[i].getCourses();
            for (int j = 0; j < courses.length; j++) {
                switch (courses[j].getCouName()){
                    case "语文":{
                        count1++;
                        break;
                    }
                    case "数学":{
                        count2++;
                        break;
                    }
                    case "英语":{
                        count3++;
                        break;
                    }
                }
            }
        }
        System.out.println("语文:"+count1+"数学:"+count2+"英语:"+count3);
    }



}
