package javase.day1.work1;

public class StudentObject {
    public static void main(String[] args) {
        // 实例化教师对象
        Student student = new Student();
        student.setStuName("张三");
        student.setStuNo("zs001");
        student.setStuAge(18);
        String stuName = student.getStuName();
        String stuNo = student.getStuNo();
        int stuAge = student.getStuAge();
        System.out.println("姓名："+stuName+" 编号："+stuNo+" 年龄："+stuAge);

    }
}
