package javase.day4.work.work4;

public class StudentController { // 接口控制器
    // 定义学生数组存放3个学生信息
    Student [] student; // 学生类型数组
    StuSerInterface stuSerInterface; // 调用学生服务接口  包含关系
    // 构造方法

    public StudentController() {
        // 实例化数组对象
        student = new Student[3];
        // 实例化接口对象
        stuSerInterface = new StudentDao(student); // 传入实体学生 依赖关系
    }

    //
    public void addStudent(Student student){
        stuSerInterface.addStudent(student);
    };
    public void deleteStudent(String stuNo){
        stuSerInterface.deleteStudent(stuNo);
    };
    public void updateStudent(Student student){
        stuSerInterface.updateStudent(student);
    };
    public void searchStudent(String stuNo){
        stuSerInterface.searchStudent(stuNo);
    };
}
