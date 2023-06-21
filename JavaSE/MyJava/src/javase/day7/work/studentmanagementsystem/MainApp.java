package javase.day7.work.studentmanagementsystem;

import java.util.Scanner;

public class MainApp {
    //测试的
    public static void main(String[] args) {
      MainApp mainApp = new MainApp();
      mainApp.page();
    }
    //界面
    public void page(){
        /*实例化Scanner用于获取键盘录入信息*/
        Scanner scanner = new Scanner(System.in);
        /*实例化一个班级对象*/
        MyClass myClass = new MyClass();
        /*将可选课程实例化并赋值*/
        Course course1 = new Course("001","Java");
        Course course2 = new Course("002","C");
        Course course3 = new Course("003","C+");
        Course course4 = new Course("004","语文");
        main1:while (true){
            System.out.println("—————————————————————————————————————————————————————————————————");
            System.out.println("|"+"\t\t\t\t\t\t"+"学 生 选 课 系 统"+"\t\t\t\t\t\t\t"+"|");
            System.out.println("|                                                               |");
            System.out.println("|       1:登 录             2:注 册              3:删除学生信息     |");
            System.out.println("|                                                               |");
            System.out.println("|       4:统计选课           5:退 出                             "+"\t"+"|");
            System.out.println("|                                                               |");
            System.out.println("—————————————————————————————————————————————————————————————————");
            /*登录*/
            String choose = scanner.next();
            if(choose.equals("1")){
                load:while (true){
                    System.out.println("—————————————————————————————————————————————————————————————————");
                    System.out.println("|"+"\t\t\t\t\t\t"+"学 生 登 录 页 面"+"\t\t\t\t\t\t\t"+"|");
                    System.out.println("|                                                               |");
                    System.out.println("|                 1:登 录                 2:退 出                "+"|");
                    System.out.println("|                                                               |");
                    System.out.println("—————————————————————————————————————————————————————————————————");
                    String choose2 = scanner.next();
                    if(choose2.equals("1")){
                        System.out.println("—————————————————————————————————————————————————————————————————");
                        System.out.println("|"+"\t\t\t\t\t"+"欢 迎 登 录 , 请 输 入 学 号:"+"\t\t\t\t\t"+"|");
                        System.out.println("—————————————————————————————————————————————————————————————————");
                        String stuNo = scanner.next();
                        int loadValue = myClass.load(stuNo);
                        /*等于-999说明数组为空，-1说明该学生不存在，但数组不为空，不等于-1其他情况登录成功*/
                        while (loadValue == -1) {
                            String stuNo2 = scanner.next();
                            int loadValue2 = myClass.load(stuNo2);
                            if (loadValue2 != -1 && loadValue2 != -999) {
                                loadValue = loadValue2;
                                break;
                            }
                        }
                        if (loadValue != -999){
                            System.out.println("—————————————————————————————————————————————————————————————————");
                            System.out.println("|"+"\t\t\t\t"+"登 录 成 功 , 学 生 选 退 课 页 面"+"\t\t\t\t\t"+"|");
                            System.out.println("|                                                               |");
                            System.out.println("|                1:选 课                 2:退 课                "+"\t"+"|");
                            System.out.println("|                                                               |");
                            System.out.println("—————————————————————————————————————————————————————————————————");
                            String choose3 = scanner.next();
                            if (choose3.equals("1")){
                                /*可选课程*/
                                myClass.CanSelectCourse();
                                selectCourse:while (true){
                                    /*建盘录入要选择的可成名*/
                                    String couName = scanner.next();
                                    switch (couName){
                                        case "Java":{
                                            myClass.getStudents()[myClass.load(stuNo)].addCourse(course1);
                                            break;
                                        }
                                        case "C":{
                                            myClass.getStudents()[myClass.load(stuNo)].addCourse(course2);
                                            break;
                                        }
                                        case "C+":{
                                            myClass.getStudents()[myClass.load(stuNo)].addCourse(course3);
                                            break;
                                        }
                                        case "语文":{
                                            myClass.getStudents()[myClass.load(stuNo)].addCourse(course4);
                                            break;
                                        }
                                        default:{
                                            System.out.println("查无此课,无法添加!");
                                            break;
                                        }
                                    }
                                    /*是否继续选课*/
                                    myClass.isSelectCourse();
                                    String choose4 = scanner.next();
                                    if (choose4.equals("1")){
                                        myClass.CanSelectCourse();
                                        continue selectCourse;
                                    }else if (choose4.equals("2")){
                                        break ;
                                    }else {
                                        System.out.println("请重新输入:");
                                    }
                                }
                            }else if (choose3.equals("2")){
                                /*键盘录入要退选的课程*/
                                /*调用退选课程方法  [myClass.load(stuNo)]表示登录成功的学生下标*/
                                while (true) {
                                    myClass.CanWithdrawCourse(stuNo);
                                    String couNo = scanner.next();
                                    int isSuccessDel = myClass.getStudents()[loadValue].delCourse(couNo);
                                    if (isSuccessDel == -777) {
                                        break;
                                    }else if (isSuccessDel == 1) {
                                        /*是否继续退选 1：是 其他：否*/
                                        myClass.isDelCourse();
                                        String choose5 = scanner.next();
                                        if (choose5.equals("1")) {
                                        } else {
                                            break;
                                        }
                                        /*当前学生未选课，结束循环*/
                                    }

                                }
                            }
                        }
                    }
                    else if(choose2.equals("2")){
                        continue main1;
                    }
                    else{
                        System.out.println("没有该选择，请重新输入:");
                    }
                }

            }
            /*注册*/
            else if(choose.equals("2")){
                System.out.println("欢迎进入注册页面请输入学生姓名,年龄,身份证号(以空格隔开)：");
                while (true){
                    /*键盘录入学生信息*/
                    String stuName = scanner.next();
                    String stuAge = scanner.next();
                    String stuId = scanner.next();
                    /*调用班级的添加学生方法，如果学生信息不规范，则要求重新输入。添加成功后记得输出添加进去的学生学号*/
                    if (myClass.addStudent(stuName,stuAge,stuId))
                        break ;
                }
                /*添加成功后打印班级学生信息*/
                myClass.GetStudentMess();


            }else if(choose.equals("3")){
                System.out.println("欢迎进入学生删除界面，可以删除的学生信息如下：");
                /*获取班级学生信息，将其显示*/
                myClass.GetStudentMess();
                System.out.println("输入你要删除的学生学号：");
                String studentNo = scanner.next();
                boolean isSucc = myClass.delStudent(studentNo);
                while (!isSucc){
                    String studentNo2 = scanner.next();
                    isSucc =myClass.delStudent(studentNo2);
                    if (studentNo2.equals("-888")){
                        break;
                    }
                }
            }
            else if(choose.equals("4")){
                System.out.println("班级选课情况如下：");
                //展示班级所有课程被选择次数
                myClass.printAllCoursesName();

            }
            else if(choose.equals("5")){
                System.out.println("欢迎下次光临");
                break main1;
            }
            else {
                System.out.println("该系统没有该选择，请重新输入:");
            }
        }
    }
}
