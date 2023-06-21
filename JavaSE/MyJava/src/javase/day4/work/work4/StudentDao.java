package javase.day4.work.work4;

public class StudentDao implements StuSerInterface { // 接口的实现子类
    Student [] student;
    // 构造方法
    public StudentDao(Student [] student) {
        this.student = student;
    }

    // 增
    int stuCount = 0; // 学生对象计数器，用于计算数组中当前对象个数
    @Override
    public void addStudent(Student student) {
        // 将接收的学生对象，存入学生类数组
        if (stuCount < 3){
            this.student[stuCount] = student; // 将获取到的学生对象存入数组
            stuCount++;
        }
        else {
            System.out.println("添加失败！！！");
        }
    }

    // 删
    @Override
    public void deleteStudent(String studNo) {
        // 以接收到的学号匹配学生对象，并将其删除
        int index = -1; // 存储目标元素下标
        for (int i = 0; i < stuCount; i++) {
            if (studNo.equals(student[i].getstuNo())){
                index = i;
                break; // 找到这个学生立即结束循环
            }
        }
        // 当index不等于-1时，说明数组中存在这个对象
        if (index != -1){
            // 删除操作 前移+补位null
            for (int i = index; i < stuCount-1; i++) {
                student[i] = student[i+1]; // 前移
            }
            student[stuCount-1] = null; // 补null
            stuCount--; // 1.数组长度－1 2.防止出现空指针报错
        }
        else {
            System.out.println("当前学生不存在！！！");
        }
    }

    // 改
    @Override
    public void updateStudent(Student student) {
        // 以接收到的学号匹配学生对象，并将其更新
        int index = -1; // 存储目标元素下标
        for (int i = 0; i < stuCount; i++) {
            if (student.getstuNo().equals(this.student[i].getstuNo())){
                index = i;
                break; // 找到这个学生立即结束循环
            }
        }
        // 当index不等于-1时，说明数组中存在这个对象
        if (index != -1){
            // 更新操作
            this.student[index] = student;
        }else {
            System.out.println("当前学生不存在！！！");
        }

    }

    // 查
    @Override
    public void searchStudent(String stuNo) {
        // 以接收到的学号匹配学生对象，并将其更新
        int index = -1; // 存储目标元素下标
        for (int i = 0; i < stuCount; i++) {
            if (stuNo.equals(this.student[i].getstuNo())){
                System.out.println(student[i]);
            }
        }
    }
}
