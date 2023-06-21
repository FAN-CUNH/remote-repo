package javase.day1.work1;

public class Account {
    // 封装Account类，成员变量private String accountName;private String accountId;
    // 编写set get方法；同时自定义方法1完成实例化2个Student对象并且完成打印2个学生的姓名信息；
    // 自定义方法2完成给任意学生的姓名修改姓名信息（即删除姓名中所有的数字）；自定义方法3完成返
    // 回本Account类的信息；封装AccountTest测试Account中方法

    private String accountName;
    private String accountId;

    // 设置属性值和获取属性值
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getAccountId() {
        return accountId;
    }
    // 构造方法
    public  Account(){

    }

    // 实例化2个Student对象并且完成打印2个学生的姓名信息
    public void stuMess(){
        // 实例化2个学生对象
        Student stu1 = new Student();
        Student stu2 = new Student();
        stu1.setStuName("李四");
        stu1.setStuNo("ls123456");
        stu1.setStuAge(18);
        stu2.setStuName("王二");
        stu2.setStuNo("we123456");
        stu2.setStuAge(18);
        System.out.println(stu1.getStuName()+" "+stu1.getStuNo()+stu1.getStuAge());
        System.out.println(stu2.getStuName()+" "+stu2.getStuNo()+stu2.getStuAge());
    }

    // 给任意学生修改姓名信息（即删除姓名中所有的数字）
    public void changeStuMess(Student student){
        String stuName = student.getStuName(); // 获取学生姓名
        for (int i = 0; i < stuName.length(); i++) {
            if (stuName.charAt(i) >= '0' && stuName.charAt(i) <= '9'){
                stuName = stuName.replace(""+stuName.charAt(i),"");
                i--;
            }
        }
        student.setStuName(stuName); // 将修改后的姓名重新赋值给对象的属性
    }

    // 返回本Account类的信息；封装AccountTest测试Account中方法
    public Account backMess(){
        return this;
    }
}
