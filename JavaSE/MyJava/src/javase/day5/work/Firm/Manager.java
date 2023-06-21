package javase.day5.work.Firm;

public class Manager extends Employee{ // 管理者是员工的子类
    // 声明私有成员变量
    private String level; // 级别

    // 构造方法
    public Manager(String name, String address, String id, double wage, int seniority, String level) {
        super(name, address, id, wage, seniority);
        this.level = level;
    }

    public Manager() {
    }

    // 重写toString方法


    @Override
    public String toString() {
        return "经理信息{" +
                "  姓名：" + this.getName() +
                ", 地址：" + getAddress() +
                ", 工号：" + getId() +
                ", 工资：" + getWage() +
                ", 工龄：" + getSeniority()+
                ", 级别：" + level+
                '}';
    }
}
