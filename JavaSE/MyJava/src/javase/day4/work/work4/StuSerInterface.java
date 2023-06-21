package javase.day4.work.work4;

public interface StuSerInterface { // 接口
    // 接口：用interface
    // 属性默认都是常量用final修饰
    String NAME = "张三";
    // 行为默认都是抽象行为用abstract修饰
    // 学生服务接口：增删改查
    public void addStudent(Student student);
    public void deleteStudent(String stuNo);
    public void updateStudent(Student student);
    public void searchStudent(String stuNo);
}
