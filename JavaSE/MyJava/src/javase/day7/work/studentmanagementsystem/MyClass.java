package javase.day7.work.studentmanagementsystem;

import java.util.Arrays;

public class MyClass {
    private String classNo;
    private String className;
    private Student[] students;
    private String[] allCourses = {"Java","C","C+","语文"};
    private int stuCount = 0;//已有学生人数
    private int setStuNo = 0;

    /*构造方法*/

    public MyClass(String classNo, String className, Student[] students, int stuCount) {
        this.classNo = classNo;
        this.className = className;
        this.students = new Student[5];
        this.stuCount = stuCount;
    }

    public MyClass() {
        students = new Student[5];
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

    public String[] getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(String[] allCourses) {
        this.allCourses = allCourses;
    }

    public int getStuCount() {
        return stuCount;
    }

    public void setStuCount(int stuCount) {
        this.stuCount = stuCount;
    }


    /*添加学生(注册)*/
    /*接收学生的信息，根据stuId（学生身份证）判断当前学生是否已被添加，若未被添加，再判断当前学生的姓名，年龄，身份证号是否符合规则，符合则注册*/
    public boolean addStudent (String stuName,String stuAge,String stuId){
        /*假设该学生可以成功添加*/
        boolean isSuccessAdd = true;
        /*假设这个学生是可以被添加的*/
        boolean isRght = true;
        for (int i = 0; i < stuCount; i++) {
            /*如果学生数组中存在和当前学生stuId相等的学生，则说明两个学生是同一个人（即已被添加）*/
            if (stuId.equals(students[i].getStuId())){
                /*修改isRight为false，表示该学生已存在，并结束循环*/
                isRght = false;
                System.out.println("该学生已存在!");
                break;
            }
        }
        /*如果isRight为真，则说明当前学生不在数组中，即未注册，执行注册操作将其添加到学生数组*/
        if (isRght){
            /*判断当前学生的姓名年龄身份证是否符合规定*/
            if (isStuNameRight(stuName) && isStuAgeRight(stuAge) && isStuIdRight(stuId)){
                if (stuCount != 5){
                    Student student = new Student();
                    /*生成学号*/
                    student.setStuNo("" + (setStuNo + 1));
                    student.setStuName(stuName);
                    student.setStuAge(stuAge);
                    student.setStuId(stuId);
                    students[stuCount] = student;
                    setStuNo++;
                    stuCount++;
                    System.out.println("添加成功，学生学号为：" + student.getStuNo());
                }else {
                    System.out.println("班级已满，不能再添加学生！退回主界面");
                }
            }else {
                /*该学生未被成功添加*/
                isSuccessAdd = false;
                System.out.println("学生信息输入有误！请重新输入:");

            }
        }
        return isSuccessAdd;
    }

    /*学生姓名规则：只能是中文，长度2-4位 [\x{4e00}-\x{9fa5}]*/
    public boolean isStuNameRight (String stuName){
        String regex = "[\\x{4e00}-\\x{9fa5}]{2,4}";
        return stuName.matches(regex);
    }
    /*学生年龄规则：只能是2位纯数字 [0-9]{2}*/
    public boolean isStuAgeRight (String stuAge){
        String regex = "[0-9]{2}";
        return stuAge.matches(regex);
    }
    /*学生身份证（假设3位）：只能是纯数字 [\x{4e00}-\x{9fa5}]*/
    public boolean isStuIdRight (String stuId){
        String regex = "[0-9]{3}";
        return stuId.matches(regex);
    }

    /*登录*/
    /*登录不成功的可能只有两种，一种是学生数组为空，另一种是当前学号对应的学生未注册（即不存在）*/
    public int load(String stuNo){
        /*下标标记，标记学生在数组中的位置，初始为-1*/
        int index = -1;
        /*找到匹配数组的学生，将其对应的下标返回*/
        for (int i = 0; i < stuCount; i++) {
            if (students[i].getStuNo().equals(stuNo)) {
                index = i;

            }
        }
        /*如果数组为空,返回特殊标记表示*/
        if (stuCount == 0) {
            System.out.println("—————————————————————————————————————————————————————————————————");
            System.out.println("|" + "\t\t\t\t\t" + "班 级 无 人 , 请 注 册 后 登 录:" + "\t\t\t\t\t" + "|");
            System.out.println("—————————————————————————————————————————————————————————————————");
            return -999;
        }
        /*如果下标为-1，说明当前学号不在数组中，但数组不为空*/
        else if (index == -1) {
            System.out.println("—————————————————————————————————————————————————————————————————");
            System.out.println("|" + "\t\t\t\t\t" + "查 无 此 人 , 请 重 新 登 录:" + "\t\t\t\t\t" + "|");
            System.out.println("—————————————————————————————————————————————————————————————————");
            return -1;
        }
        /*返回登录学生的数组下标*/
        return index;
    }

    /*删除学生：根据学生学号删除学生信息*/
    public boolean delStudent (String stuNo){
        /*假设不能删除，即数组中没有这个人*/
        boolean isNot = false;
        /*循环遍历数组，用stuNo匹配学生数组中学生的学号*/
        if (stuCount == 0){
            System.out.println("没有学生，无法删除!退出删除界面");
            isNot = true;
        }
        for (int i = 0; i < stuCount; i++) {
            if (students[i].getStuNo().equals(stuNo)){
                Student student = students[i];
                /*匹配成功 执行删除*/
                isNot = true;
                for (int j = i; j < stuCount; j++) {
                    students[j] = students[j+1];
                }
                System.out.println(student.getStuName()+"已被移除班级!");
                stuCount--;
            }else if (!stuNo.equals("-888") && i == stuCount-1 && !(students[i].getStuNo().equals(stuNo))){
                System.out.println("—————————————————————————————————————————————————————————————————");
                System.out.println("|" + "\t\t" + "查 无 此 人 , 请 重 新 输 入(或 输 入 -888 退 出):" + "\t\t\t" + "|");
                System.out.println("—————————————————————————————————————————————————————————————————");
            }
        }
        return isNot;
    }

    //统计课程选择情况
    public void printAllCoursesName(){
        /*循环遍历取出每个学生，然后在循环遍历每个学生的已选课程，统计每个课程的数目*/
        int count1  = 0;
        int count2  = 0;
        int count3  = 0;
        int count4  = 0;
        for (int i = 0; i < stuCount; i++) {
            Course[] courses = students[i].getCourses();
            for (int j = 0; j < students[i].getCourseCount(); j++) {
                switch (courses[j].getCouName()){
                    case "Java":{
                        count1++;
                        break;
                    }
                    case "C":{
                        count2++;
                        break;
                    }
                    case "C+":{
                        count3++;
                        break;
                    }
                    case "语文":{
                        count4++;
                        break;
                    }
                }
            }
        }
        //System.out.println("Java:"+count1+", C:"+count2+", C+:"+count3+", 语文:"+count4);
        System.out.println("—————————————————————————————————————————————————————————————————");
        System.out.println("|"+"\t\t\t\t\t\t"+"班 级 选 课 情 况 如 下"+"\t\t\t\t\t"+"|");
        System.out.println("|                                                               |");
        System.out.println("|"+"\t\t\t\t"+"Java:"+count1+"人"+"\t\t\t"+"C:"+count2+"人"+"\t\t\t\t\t\t"+"|");
        System.out.println("|                                                               |");
        System.out.println("|"+"\t\t\t\t"+"C+:"+count3+"人"+"\t\t\t\t"+"语文:"+count4+"人"+"\t\t\t\t\t\t"+"|");
        System.out.println("|                                                               |");
        System.out.println("—————————————————————————————————————————————————————————————————");
    }



    @Override
    public String toString() {
        return "班级信息{" +
                "学生" + Arrays.toString(students) +
                ", 可选课程" + Arrays.toString(allCourses) +
                '}';
    }
    public void CanSelectCourse(){
        System.out.println("—————————————————————————————————————————————————————————————————");
        System.out.println("|"+"\t\t\t\t\t\t"+"请 选 择 以 下 课 程"+"\t\t\t\t\t\t"+"|");
        System.out.println("|                                                               |");
        System.out.println("|\t\t "+getAllCourses()[0]+"\t\t\t "+getAllCourses()[1]+"\t\t\t "+getAllCourses()[2]+"\t\t\t "+getAllCourses()[3]+"\t\t\t"+"|");
        System.out.println("|                                                               |");
        System.out.println("—————————————————————————————————————————————————————————————————");
    }
    public void CanWithdrawCourse(String stuNo){
        System.out.println("—————————————————————————————————————————————————————————————————");
        System.out.println("|"+"\t\t\t\t\t\t"+"学 生 可 退 选 课 程"+"\t\t\t\t\t\t"+"|");
        System.out.println("|                                                               |");
        for (int i = 0; i < stuCount; i++) {
            /*匹配当前登录学生*/
            if (students[i].getStuNo().equals(stuNo)){
                /*匹配成功，取出学生对象*/
                Student student = students[i];
                /*遍历学生对象的课程数组*/
                for (int j = 0; j < student.getCourseCount(); j++) {
                    /*获取每个课程的对象*/
                    Course course = student.getCourses()[j];
                    /*课程不为空，输出课程信息*/
                    if (course != null){
                        System.out.println("|"+"\t\t\t\t"+course.getCouName()+"课 程 对 应 的 课 程 编 号 :  "+course.getCouNo()+"\t\t\t\t"+"|");
                    }
                }
            }
        }
        System.out.println("|                                                               |");
        System.out.println("—————————————————————————————————————————————————————————————————");
    }
    public void GetStudentMess(){
        System.out.println("—————————————————————————————————————————————————————————————————");
        System.out.println("|"+"\t\t\t\t\t\t"+"学 生 信 息 如 下"+"\t\t\t\t\t\t\t"+"|");
        System.out.println("|                                                               |");
        for (int i = 0; i < stuCount; i++) {
            System.out.println("|  "+getStudents()[i]+"  |");
        }
        System.out.println("|                                                               |");
        System.out.println("—————————————————————————————————————————————————————————————————");
    }
    public void isSelectCourse(){
        System.out.println("—————————————————————————————————————————————————————————————————");
        System.out.println("|"+"\t\t\t\t\t\t"+"是 否 继 续 选 课"+"\t\t\t\t\t\t\t"+"|");
        System.out.println("|                                                               |");
        System.out.println("|                1:是                  2:否                "+"\t\t"+"|");
        System.out.println("|                                                               |");
        System.out.println("—————————————————————————————————————————————————————————————————");
    }
    public void isDelCourse(){
        System.out.println("—————————————————————————————————————————————————————————————————");
        System.out.println("|"+"\t\t\t\t\t\t"+"是 否 继 续 退 课"+"\t\t\t\t\t\t\t"+"|");
        System.out.println("|                                                               |");
        System.out.println("|                1:是                  2:否                "+"\t\t"+"|");
        System.out.println("|                                                               |");
        System.out.println("—————————————————————————————————————————————————————————————————");
    }
}
